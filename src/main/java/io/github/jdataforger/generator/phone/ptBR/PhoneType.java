package io.github.jdataforger.generator.phone.ptBR;

public enum PhoneType {
    MOBILE("Celular"),
    FIXED("Fixo");

    private final String text;

    /**
     * @param text
     */
    PhoneType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
