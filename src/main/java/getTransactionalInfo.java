import com.exacttarget.fuelsdk.*;
import com.exacttarget.fuelsdk.ETSubscriberList;
import com.exacttarget.fuelsdk.internal.Owner;

public class getTransactionalInfo {

    private String sid = "100016197";
    private String lid = "411309";
    private String cid = "25349";

    public void getAllList(ETClient client) throws ETSdkException
    {
        try {
            ETFilter etf = new ETFilter();
            etf.addProperty("id");
            etf.addProperty("key");
            etf.addProperty("name");
            etf.addProperty("description");
            etf.addProperty("type");

            ETResponse<ETList> response = client.retrieve(ETList.class, etf);
            System.out.println("resp="+ response.toString());
            ETResult<ETList> result = response.getResult();
            System.out.println("res="+ result.toString());
        } catch (ETSdkException ex) {
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

        }catch (Exception e) {
            e.getCause().printStackTrace();
        }
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
        try {
            ETResponse<ETClickEvent> response = client.retrieve(ETClickEvent.class);
            System.out.println("resp=" + response.toString());
        }catch (Exception e){
            e.getCause().printStackTrace();
        }


    }

    public void getAllSummary(ETClient client) throws ETSdkException
    {
        ETResponse<ETTriggeredSendSummary> response = client.retrieve(ETTriggeredSendSummary.class);
        //System.out.println("resp="+ response.toString());


        ETResult<ETTriggeredSendSummary> result = response.getResult();
        System.out.println("res="+ result.toString());


    }

    public void getAllResultMessage(ETClient client) throws ETSdkException
    {
        ETResponse<ETResultMessage> response = client.retrieve(ETResultMessage.class);
        System.out.println("resp="+ response.toString());


    }

    public void getAllOpens(ETClient client) throws ETSdkException {
        ETResponse<ETOpenEvent> response = client.retrieve(ETOpenEvent.class);
        System.out.println("resp="+ response.toString());

    }

    public void getAllTriggeredEmails(ETClient client){
        try {
            ETFilter etf = new ETFilter();
            etf.addProperty("id");
            etf.addProperty("key");
            etf.addProperty("name");
            etf.addProperty("description");
            etf.addProperty("folderId");
            etf.addProperty("email");
            etf.addProperty("subject");
            etf.addProperty("priority");
            etf.addProperty("status");

            ETResponse<ETTriggeredEmail> response = client.retrieve(ETTriggeredEmail.class, etf);
            System.out.println("resp="+ response.toString());



            ETResult<ETTriggeredEmail> result = response.getResult();
            System.out.println("res="+ result.toString());
        } catch (ETSdkException ex) {
            ex.printStackTrace();
        }

    }

    public void getAllSubscribers(ETClient client) throws ETSdkException
    {
        ETFilter etf = new ETFilter();
        etf.addProperty("id");
        etf.addProperty("key");
        etf.addProperty("emailAddress");
        etf.addProperty("status");
        etf.addProperty("preferredEmailType");

        ETResponse<ETSubscriber> response = client.retrieve(ETSubscriber.class, etf);
        System.out.println("resp="+ response.toString());

        ETResult<ETSubscriber> result = response.getResult();
        System.out.println("res="+ result.toString());
    }

    public void getAllSents(ETClient client) throws ETSdkException {
        ETResponse<ETSentEvent> response = client.retrieve(ETSentEvent.class);
        System.out.println("resp="+ response.toString());

    }

    public void getSentFromSpecificSender(ETClient client,String email) throws ETSdkException {
        ETResponse<ETSentEvent> response = client.retrieve(ETSentEvent.class, "subscriberKey="+email);
        System.out.println("resp="+ response.toString());

        ETResult<ETSentEvent> result = response.getResult();
        System.out.println("res="+ result.toString());;
    }

    public void getAllBounces(ETClient client) throws ETSdkException {

        ETResponse<ETBounceEvent> response = client.retrieve(ETBounceEvent.class);
        System.out.println("resp="+ response.toString());

        ETResult<ETBounceEvent> result = response.getResult();
        System.out.println("res="+ result.toString());

    }


    public static void main(String[] args) throws ETSdkException
    {
        getTransactionalInfo t = new getTransactionalInfo();
        ETClient client = new ETClient();

        //t.getAllSummary(client);              //retrieves summary of triggered send
        //t.getAllResultMessage(client);
       //t.getAllList(client);
        t.getAllUnsubs(client);                   //fetches all unsubscribers
       // t.getAllOpens(client);                   //fetches all opened emails
        //t.getAllTriggeredEmails(client);        //retrieve triggered emails
        //t.getAllSubscribers(client);            //fetches all subscribers
        //t.getAllSents(client);                  //fetches all email sent
        //t.getAllBounces(client);                //Fetches all bounced or not successfully sent emails

        //t.getSentFromSpecificSender(client,"david.hoffmann@geminidsystems.com");        //fetches specific sents emails from a email



        //t.getAllClicks(client);           // Not Working
        //t.getAllCampaign(client);         //Not Working
        //t.getAllEmail(client);            //Not Working

    }
}

