import com.exacttarget.fuelsdk.*;
import com.exacttarget.fuelsdk.ETSubscriberList;

public class getTransactionalInfo {

    private String sid = "100016197";
    private String lid = "411309";
    private String cid = "25349";

    public void getList(ETClient client) throws ETSdkException
    {
       try {

            ETFilter etf = new ETFilter();
            etf.addProperty("id");
            etf.addProperty("key");
            etf.addProperty("name");
            etf.addProperty("description");
            etf.addProperty("type");

            ETExpression exp = new ETExpression();
            exp.setProperty("id");
            exp.setOperator("=");
            exp.setValue(lid);
            etf.setExpression(exp);

            ETResponse<ETList> response = client.retrieve(ETList.class);
            System.out.println("resp="+ response.toString());


            ETResult<ETList> result = response.getResult();
            System.out.println("res="+ result.toString());

        }catch (ETSdkException ex){
           ex.printStackTrace();
        }
    }

    public void getAllCampaign(ETClient client) throws ETSdkException
    {
        try {
            ETResponse<ETCampaign> response = client.retrieve(ETCampaign.class);
    //      System.out.println("resp="+ response.toString());

            ETResult<ETCampaign> result = response.getResult();
          //System.out.println("res="+ result.toString());

        }catch (ETSdkException ex) {
            ex.printStackTrace();
        }
    }

    public void getAllSubscriberList(ETClient client) throws ETSdkException
    {
        ETFilter etf = new ETFilter();
        etf.addProperty("id");
        //etf.addProperty("action");
        //etf.addProperty("emailAddress");
        etf.addProperty("status");
       // etf.addProperty("preferredEmailType");

        ETResponse<ETSubscriberList> response = client.retrieve(ETSubscriberList.class,etf);
        System.out.println("resp="+ response.toString());


        ETResult<ETSubscriberList> result = response.getResult();
        System.out.println("res="+ result.toString());
    }
    public void getAllUnsubs(ETClient client) throws ETSdkException {
        ETResponse<ETUnsubEvent> response = client.retrieve(ETUnsubEvent.class);
        System.out.println("resp="+ response.toString());
    }
    public void getAllEmail(ETClient client) throws ETSdkException
    {
       try {
            ETResponse<ETEmail> response = client.retrieve(ETEmail.class);
            System.out.println("resp="+ response.toString());


            ETResult<ETEmail> result = response.getResult();
            System.out.println("res="+ result.toString());
       } catch (ETSdkException ex) {
                ex.printStackTrace();
       }
    }

    public void getAllClicks(ETClient client) throws ETSdkException {
        ETResponse<ETClickEvent> response = client.retrieve(ETClickEvent.class);
        System.out.println("resp="+ response.toString());


    }

    public void getAllSummary(ETClient client) throws ETSdkException
    {
        ETResponse<ETTriggeredSendSummary> response = client.retrieve(ETTriggeredSendSummary.class);
        //System.out.println("resp="+ response.toString());


        ETResult<ETTriggeredSendSummary> result = response.getResult();
        System.out.println("res="+ result.toString());
        //assertNotNull(result.getObject());

    }

    public void getAllResultMessage(ETClient client) throws ETSdkException
    {
        ETResponse<ETResultMessage> response = client.retrieve(ETResultMessage.class);
        System.out.println("resp="+ response.toString());


    }


    public static void main(String[] args) throws ETSdkException
    {
        getTransactionalInfo t = new getTransactionalInfo();
        ETClient client = new ETClient();

        //t.getAllSummary(client);
        //t.getAllResultMessage(client);
        //t.getAllSubscriberList(client);
       // t.getList(client);
        t.getAllUnsubs(client);

        //t.getAllClicks(client);           // Not Working
       // t.getAllCampaign(client);         //Not Working

    }
}

