public class Email {
    private String subject;
    private String content;
    private boolean isHtml;
    private boolean isExternal;
    private boolean encryptedWithAES;
    private boolean encryptedWithDES;

    public Email(String subject, String content, boolean isHtml, boolean isExternal, boolean encryptedWithAES, boolean encryptedWithDES) {
        this.subject = subject;
        this.content = content;
        this.isHtml = isHtml;
        this.isExternal = isExternal;
        this.encryptedWithAES = encryptedWithAES;
        this.encryptedWithDES = encryptedWithDES;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public boolean isExternal() {
        return isExternal;
    }

    public boolean isEncryptedWithAES() {
        return encryptedWithAES;
    }

    public boolean isEncryptedWithDES() {
        return encryptedWithDES;
    }
}
