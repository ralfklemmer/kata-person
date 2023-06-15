package sammancoaching;

class SwedishPersonalNumber {

    private String swedishPersonalNumber;

    public SwedishPersonalNumber(String swedishPersonalNumber) {
        setSwedishPersonalNumber(swedishPersonalNumber);
    }

    public void setSwedishPersonalNumber(String swedishPersonalNumber) {
        swedishPersonalNumber = swedishPersonalNumber.replace("-", "");
        if (swedishPersonalNumber.length() != 12)
            throw new IllegalArgumentException("invalid personal number " + swedishPersonalNumber);
        this.swedishPersonalNumber = swedishPersonalNumber;
    }

    public int birthYear() {
        String year = swedishPersonalNumber.substring(0, 4);
        return Integer.parseInt(year);
    }
}
