import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Factory method pattern
 * Electric Bill Generation
 * Created by ashwin on 10/12/16
 */

public class BillGenerator
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter plan type: ");
        String planType = br.readLine();

        System.out.print("Enter units consumed: ");
        int units = Integer.parseInt(br.readLine());

        GetPlanFactory getPlanFactory = new GetPlanFactory();

        Plan plan = getPlanFactory.getPlan(planType);

        plan.getRate();
        plan.calculateBill(units);
    }
}


abstract class Plan
{
    protected double rate;

    abstract void getRate();

    public void calculateBill(int units)
    {
        System.out.println("$"+rate*units);
    }
}

class DomesticPlan extends Plan
{
    void getRate()
    {
        rate = 3.50;
    }
}

class InstitutionalPlan extends Plan
{
    void getRate()
    {
        rate = 5.50;
    }
}

class CommercialPlan extends  Plan
{
    void getRate()
    {
        rate = 7.50;
    }
}

//factory method
class GetPlanFactory
{
    public Plan getPlan(String planType)
    {
        if(planType == null)
        {
            return null;
        }

        if(planType.equalsIgnoreCase("DOMESTIC"))
        {
            return new DomesticPlan();
        }

        if(planType.equalsIgnoreCase("INSTITUTIONAL"))
        {
            return new InstitutionalPlan();
        }

        if(planType.equalsIgnoreCase("COMMERCIAL"))
        {
            return new CommercialPlan();
        }

        return null;
    }
}