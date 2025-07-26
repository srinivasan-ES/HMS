package com.management.HospitalClient.utility;

public class MailSubjectAndContent {

    public static final String patientRegistrationSubject = "Welcome to Our Hospital – Patient ID Created";
    public static final String patientRegistration = """
            Dear Patient,
            
            Your registration is successful. Your Patient ID has been created.
            
            We wish you a speedy recovery!
            
            Best regards, \s
            Hospital Management Team""";
    public static final String appointmentConfirmationSubject = "Appointment Confirmed – Please Visit Your Doctor On Time";
    public static final String appointmentConfirmation = """
            Dear Patient,
            
            Your appointment has been confirmed successfully.

            Please make sure to visit your doctor at the scheduled time.

            Thank you, \s
            Hospital Management Team""";
    public static final String billingCompletionSubject = "Billing Completed – Kindly Visit the Billing Counter";
    public static final String billingCompletion = """
            Dear Patient,
            
            Your bill has been generated successfully.
            
            Please visit the billing counter to complete the process.
            
            Thank you, \s
            Hospital Billing Department""";
    public static final String fromEmail= "srinivasan.e0995@gmail.com";
    public static final String textPlan= "text/plain";
    public static final String sendMail= "mail/send";
}
