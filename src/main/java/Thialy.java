public class Thialy {
    public static void main(String[] args) {
        String data1 = "05/2020";
        String data2 = "07/2021";

        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("MM/yyyy");

        try{
            java.time.LocalDate date1 = java.time.YearMonth.parse(data1, formatter).atDay(1);
            java.time.LocalDate date2 = java.time.YearMonth.parse(data2, formatter).atDay(1);

            long diferencaEmMeses = java.time.temporal.ChronoUnit.MONTHS.between(date1, date2);
            System.out.println("Global.CALC_BUREAU_DATA_VALIDA.setValue(\"S\");");

        } catch (java.time.format.DateTimeParseException dtpe){
            System.out.println("Global.CALC_BUREAU_DATA_VALIDA.setValue(\"P\");");
        }
    }
}
