interface Notification {
    void envoyer(Client client, String message);
}

class NotificationSMS implements Notification {
    @Override public void envoyer(Client client, String message) {
        System.out.println("[SMS -> " + client.getTel() + "] " + message);
    }
}

class NotificationEmail implements Notification {
    @Override public void envoyer(Client client, String message) {
        System.out.println("[EMAIL -> " + client.getEmail() + "] " + message);
    }
}

class NotificationVoixRobot implements Notification {
    @Override public void envoyer(Client client, String message) {
        System.out.println("[ROBOT VOIX] Bonjour " + client.getNom() + " : " + message);
    }
}
