package com.umb.taller.application;

public class UserManager {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final EmailService emailService;
    private final ActivityLogger activityLogger;
    private final ReportService reportService;

    public UserManager(
            UserService userService,
            EmailValidator emailValidator,
            EmailService emailService,
            ActivityLogger activityLogger,
            ReportService reportService) {
        this.userService = userService;
        this.emailValidator = emailValidator;
        this.emailService = emailService;
        this.activityLogger = activityLogger;
        this.reportService = reportService;
    }

    public boolean createUser(String nombre, String email) {
        if (!emailValidator.validateEmail(email)) {
            activityLogger.logActivity("Intento de crear usuario con email inválido: " + email);
            return false;
        }

        userService.createUser(nombre, email);
        activityLogger.logActivity("Usuario creado: " + nombre);
        emailService.sendEmail(email, "Bienvenido " + nombre + " al sistema.");
        return true;
    }

    public void sendEmail(String email, String message) {
        emailService.sendEmail(email, message);
        activityLogger.logActivity("Email enviado a: " + email);
    }

    public boolean validateEmail(String email) {
        return emailValidator.validateEmail(email);
    }

    public void generateReport() {
        reportService.generateReport();
        activityLogger.logActivity("Reporte generado");
    }

    public void logActivity(String activity) {
        activityLogger.logActivity(activity);
    }
}
