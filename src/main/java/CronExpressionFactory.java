public class CronExpressionFactory {
    public static CronExpression getCronExpressionFromString(String[] s) {
        // if s.lenght !=5 throw exception
        CronExpression cronExpression = new CronExpression();
        cronExpression.setMinute(new Minute(s[0]));
        cronExpression.setHour(new Hour(s[1]));
        cronExpression.setDayOfMonth(new DayOfMonth(s[2]));
        cronExpression.setMonth(new Month(s[3]));
        cronExpression.setDayOfWeek(new DayOfWeek(s[4]));


        return cronExpression;
    }
}
