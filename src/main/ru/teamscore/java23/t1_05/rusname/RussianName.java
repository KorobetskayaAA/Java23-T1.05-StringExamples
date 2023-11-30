package ru.teamscore.java23.t1_05.rusname;

public class RussianName {
    private String personalName;
    private String patronymic;
    private String familyName;

    public RussianName(String familyName, String personalName, String patronymic) {
        this.personalName = personalName.strip();
        this.patronymic = patronymic.strip();
        this.familyName = familyName.strip();
    }

    public RussianName(String familyName, String personalName) {
        this.personalName = personalName.strip();
        this.familyName = familyName.strip();
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public boolean hasPatronymic() {
        return patronymic != null && !patronymic.isEmpty() && !patronymic.isBlank();
    }

    public String getFullName() {
        return personalName + " " + (hasPatronymic() ? patronymic + " " : "") + familyName;
    }

    public String getFullAlphabeticName() {
        return String.format("%s %s%s",
                familyName,
                personalName,
                hasPatronymic() ? " " + patronymic : "");
    }

    private String getAbbreviation(String namePart) {
        if (namePart == null || namePart.isEmpty() || namePart.isBlank()) {
            return "";
        }
        return namePart.substring(0, 1).toUpperCase() + ".";
    }

    public String getAbbreviatedName() {
        return String.join(" ",
                hasPatronymic()
                        ?
                        new String[]{getAbbreviation(personalName),
                                getAbbreviation(patronymic),
                                familyName}
                        :
                        new String[]{getAbbreviation(personalName),
                                familyName});
    }

    public String getAbbreviatedAlphabeticName() {
        StringBuilder sb = new StringBuilder();
        sb.append(familyName);
        sb.append(" ");
        sb.append(getAbbreviation(personalName));
        if (hasPatronymic()) {
            sb.append(getAbbreviation(patronymic));
        }
        return sb.toString();
    }
}
