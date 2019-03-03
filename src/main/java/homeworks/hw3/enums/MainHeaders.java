package homeworks.hw3.enums;

public enum MainHeaders {
    FIRST_MAIN_HEADER("EPAM FRAMEWORK WISHES…"),
    SECOND_MAIN_HEADER("LOREM IPSUM DOLOR SIT AMET, " +
                                    "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
                                    "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
                                    "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
                                    "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    private String text;

    MainHeaders (String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
