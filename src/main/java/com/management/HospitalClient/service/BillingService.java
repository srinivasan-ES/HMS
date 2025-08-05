package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.*;
import com.management.HospitalClient.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.management.HospitalClient.utility.MailSubjectAndContent.billingCompletion;
import static com.management.HospitalClient.utility.MailSubjectAndContent.billingCompletionSubject;

@Service
public class BillingService {

    @Autowired
    BillingRepository billingRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    DoctorRepository doctorMasterDataRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    MedicineVariantMasterDataRepository masterDataRepository;

    public BillingEntity createBilling(Long appointmentId) {

        AppointmentEntity appointment = getAppointmentEntity(appointmentId);
        double doctorFee = getDoctorFee(appointment);
        double totalMedicineCost = getTotalMedicineCost(appointmentId);
        double totalCost=doctorFee+totalMedicineCost;
        BillingEntity billingEntity = getBillingEntity(appointmentId, doctorFee, totalMedicineCost, totalCost);
        sendMail(appointment);
        return billingEntity;
    }

    private void sendMail(AppointmentEntity appointment) {
        emailService.sendEmail(appointment.getPatient().getEmailAddress(), billingCompletionSubject, billingCompletion);
    }

    private BillingEntity getBillingEntity(Long appointmentId, double doctorFee, double totalMedicineCost, double totalCost) {
        BillingEntity billingEntity=new BillingEntity();
        billingEntity.setAppointmentId(appointmentId);
        billingEntity.setDoctorFee(doctorFee);
        billingEntity.setMedicineCost(totalMedicineCost);
        billingEntity.setTotal(totalCost);
        billingEntity.setBillingDate(new Date().toString());
        billingEntity.setPaymentStatus("UnPaid");
        billingRepository.save(billingEntity);
        return billingEntity;
    }

    private double getTotalMedicineCost(Long appointmentId) {
        PrescriptionEntity prescriptionEntity=prescriptionRepository
                .findByAppointmentId(appointmentId);
        System.out.println(prescriptionEntity.getAppointmentId());
        List<MedicineEntity> medicineEntityList=prescriptionEntity.getMedicines();
        double totalMedicineCost=0;
        for(MedicineEntity medicine:medicineEntityList){
            MedicineVariantEntity variantEntity=medicine.getMedicineVariantEntity();
            double unitPrice=variantEntity.getPrice();
            totalMedicineCost+=unitPrice*medicine.getQuantity();
        }
        return totalMedicineCost;
    }

    private double getDoctorFee(AppointmentEntity appointment) {
        double doctorFee=0;
        DoctorEntity doctorMasterDataEntity=doctorMasterDataRepository
                .findById(appointment.getDoctorId()).orElse(new DoctorEntity());
        List<DoctorMasterDataEntity> masterDataEntities=doctorMasterDataEntity.getMasterDataEntities();
        for(DoctorMasterDataEntity doctorMasterData:masterDataEntities){
            if (Objects.equals(appointment.getSpeciality(), doctorMasterData.getSpeciality())) {
                doctorFee = Double.parseDouble(doctorMasterData.getConsultationFees());
                break;
            }
        }
        return doctorFee;
    }

    private AppointmentEntity getAppointmentEntity(Long appointmentId) {
        AppointmentEntity appointment = appointmentRepository.findById(appointmentId)
                .orElse(new AppointmentEntity());
        return appointment;
    }

    public BillingEntity getBilling(long id) {

        return billingRepository.findById(id).orElse(new BillingEntity());
    }

    public void deleteBilling(long id) {

        billingRepository.deleteById(id);
    }

    public List<BillingEntity> getBillingList() {

        return billingRepository.findAll();
    }

    public BillingEntity updateBilling(Long appointmentId) {

        BillingEntity billingEntity =  billingRepository.findByAppointmentId(appointmentId);
        billingEntity.setPaymentStatus("Paid");
        billingRepository.save(billingEntity);
        return billingEntity;
    }
}
