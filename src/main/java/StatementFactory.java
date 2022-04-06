import java.io.IOException;


public class StatementFactory {
    public static Statement getStatementFromArg(String s) throws IOException {
        Statement statement = new Statement();

        String [] splitStr =s.split("\\s") ;
        if(splitStr.length!=6)
            throw new IOException("Wrong Format : "+"Length not equal to 6 after splitting with space" );
        statement.setCommand(new Command(splitStr[5]));
        CronExpression cronExpression = CronExpressionFactory.getCronExpressionFromString(splitStr);
        statement.setCronExpression(cronExpression);


        return statement;
    }


}
