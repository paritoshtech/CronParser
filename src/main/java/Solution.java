/*
You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
     "60,mail.yahoo.com",
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "5,com.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts) =>
com:                     1345
google.com:              900
stackoverflow.com:       10
overflow.com:            20
yahoo.com:               410
mail.yahoo.com:          60
mobile.sports.yahoo.com: 10
sports.yahoo.com:        50
com.com:                 5
org:                     3
wikipedia.org:           3
en.wikipedia.org:        2
m.wikipedia.org:         1
mobile.sports:           1
sports:                  1
uk:                      1
co.uk:                   1
google.co.uk:            1

n: number of domains in the input
(individual domains and subdomains have a constant upper length)
*/


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    private static String [] getDomains(String subDomain)
    {
//        System.out.println("FQDN "+subDomain);

        String [] splitArray= subDomain.split("\\.",-1);
//        System.out.println("FQDN "+subDomain+" split length "+splitArray.length);

        int n = splitArray.length;
       for(int i =0 ; i < n ; i++)
       {
           String temp="";
           for(int j =i ; j < n ; j++)
           {
               if(temp=="")
                   temp=splitArray[j];
               else
                   temp=temp+"."+splitArray[j];
           }
           splitArray[i]=temp;
       }

        return splitArray;
    }

    private static HashMap<String , Integer > counter (String [] counts)
    {
        int n = counts.length;
        HashMap<String,Integer> solMap = new HashMap<String,Integer>();

        for(int i =0 ; i < n ; i++)
        {
            String [] temp = counts[i].split(",",2);
            int count = Integer.parseInt(temp[0]);
            String fullDomain = temp[1];
            String [] domains = getDomains(fullDomain);
            // System.out.println("domain lenght "+ domains.length);
            for(String sd: domains)
            {

//                System.out.println("sd "+ sd);

                Integer existingCount= solMap.get(sd);
                if(Objects.isNull(existingCount))
                    existingCount=0;
                // System.out.println("existingCount "+ existingCount);


                solMap.put(sd,count+existingCount);
            }


        }

        return solMap;
    }
    public static HashMap<String, Integer>
    sortByValue(HashMap<String, Integer> hm)
    {
        HashMap<String, Integer> temp
                = hm.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return temp;
    }
    public static void main(String[] argv) {

        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        HashMap<String,Integer> hitMap =  sortByValue(counter(counts));

        for(Map.Entry<String,Integer> temp : hitMap.entrySet() )
        {
            System.out.println(temp.getKey()+" : "+temp.getValue());
        }


    }


}
