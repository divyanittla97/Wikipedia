import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.*;
import org.json.JSONException;
import org.json.JSONObject;


public class wiki {
//for tech people
	public static void main(String[] args) throws IOException, JSONException {
		InputStreamReader b=new InputStreamReader(System.in);
		BufferedReader cr=new BufferedReader(b);
		String str1,str2;
		System.out.println("Enter str1");
		str1=cr.readLine();
		System.out.println("Enter str2");
		str2=cr.readLine();
		//This is the url whole main page
		String fulltext="https://en.wikipedia.org/w/api.php?action=query&titles="+str1+"%20"+str2+"&format=json&prop=extracts";
		//This is the url of the infobox
		String infobox="https://en.wikipedia.org/w/api.php?action=query&prop=revisions&rvprop=content&format=json&titles="+str1+"%20"+str2+"&section=0";
		//This is the url for the summary
        String summary="https://en.wikipedia.org/w/api.php?action=query&titles="+str1+"%20"+str2+"&format=json&prop=extracts&exintro";
        //This contains the data of the main page
		String text1 = callURL(fulltext);
		//This contains the data of the infobox
		String text2 = callURL(infobox);
		//this contains the data of the summary
		String text3 = callURL(summary);
		BufferedWriter output = null;
		try {
            File file1 = new File("mainpage.json");
            output = new BufferedWriter(new FileWriter(file1,true));
            output.write(text1);
            File file2 = new File("infobox.json");
            output = new BufferedWriter(new FileWriter(file2,true));
            output.write(text2);
            File file3 = new File("summary.json");
            output = new BufferedWriter(new FileWriter(file3,true));
            output.write(text3);
            File dynamicfile1 = new File("file1.json");
            output = new BufferedWriter(new FileWriter(dynamicfile1));
            output.write(text1);
            File dynamicfile2 = new File("file2.json");
            output = new BufferedWriter(new FileWriter(dynamicfile2));
            output.write(text2);
            File dynamicfile3 = new File("file3.json");
            output = new BufferedWriter(new FileWriter(dynamicfile3));
            output.write(text3);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }
	}
	
	
	//FOR birth_date 
//	InputStream is = null; 
//  InputStreamReader isr = null;
//  BufferedReader br = null;
//  String txt=null;
//  try{
//     // open input stream test.txt for reading purpose.
//     is = new FileInputStream("file2.json");
//     // create new input stream reader
//     isr = new InputStreamReader(is);
//     
//     // create new buffered reader
//     br = new BufferedReader(isr);
//  
//     int value=0;
//     
//     // reads to the end of the stream 
//     while((value = br.read()) != -1)
//     {
//        // converts int to character
//        char c = (char)value;
//        txt=txt+(c);
//     
//     }
//  }
//  catch(Exception e){
//      e.printStackTrace();
//   }finally{
//      
//      // releases resources associated with the streams
//     if(is!=null)
//        is.close();
//    if(isr!=null)
//        isr.close();
//     if(br!=null)
//         br.close();
//  }
//  int index1=txt.length();
//  System.out.println(index1);
// int int1=txt.indexOf("birth_date");
//  if(int1==-1){
// 	 System.out.println("bleh "); 
//  }
// else{
// 	 System.out.println(int1);
// 	int index2=0;
//  for(int i=int1;i<index1;i++){
//	  if(txt.charAt(i)=='n'&&txt.charAt(i+1)=='|'){
//   		index2=i;
//   		break;
//   	}
//  }
// System.out.println(index2);
// System.out.println(txt.substring(int1, index2-2));
// 	 }
//}
	
	//FOR DEATH_DATE      InputStream is = null; 
//  InputStreamReader isr = null;
//  BufferedReader br = null;
//  String txt=null;
//  try{
//     // open input stream test.txt for reading purpose.
//     is = new FileInputStream("file2.json");
//     // create new input stream reader
//     isr = new InputStreamReader(is);
//     
//     // create new buffered reader
//     br = new BufferedReader(isr);
//  
//     int value=0;
//     
//     // reads to the end of the stream 
//     while((value = br.read()) != -1)
//     {
//        // converts int to character
//        char c = (char)value;
//        txt=txt+(c);
//     
//     }
//  }
//  catch(Exception e){
//      e.printStackTrace();
//   }finally{
//      
//      // releases resources associated with the streams
//     if(is!=null)
//        is.close();
//    if(isr!=null)
//        isr.close();
//     if(br!=null)
//         br.close();
//  }
//  int index1=txt.length();
//  System.out.println(index1);
// int int1=txt.indexOf("death_date");
//  if(int1==-1){
// 	 System.out.println("bleh "); 
//  }
// else{
// 	 System.out.println(int1);
// 	int index2=0;
//  for(int i=int1;i<index1;i++){
//	  if(txt.charAt(i)=='n'&&txt.charAt(i+1)=='|'){
//   		index2=i;
//   		break;
//   	}
//  }
// System.out.println(index2);
// System.out.println(txt.substring(int1, index2-2));
// 	 }
//}
       
        
//FOR NETWORTH        InputStream is = null; 
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        String txt=null;
//        try{
//           // open input stream test.txt for reading purpose.
//           is = new FileInputStream("file2.json");
//           // create new input stream reader
//           isr = new InputStreamReader(is);
//           
//           // create new buffered reader
//           br = new BufferedReader(isr);
//        
//           int value=0;
//           
//           // reads to the end of the stream 
//           while((value = br.read()) != -1)
//           {
//              // converts int to character
//              char c = (char)value;
//              txt=txt+(c);
//           
//           }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//         }finally{
//            
//            // releases resources associated with the streams
//            if(is!=null)
//               is.close();
//            if(isr!=null)
//               isr.close();
//            if(br!=null)
//               br.close();
//         }
//        int index1=txt.length();
//        System.out.println(index1);
//        int int1=txt.indexOf("networth");
//         if(int1==-1){
//        	 System.out.println("bleh "); 
//          }
//         else{
//        	 System.out.println(int1);
//        	 int index2=0;
//             for(int i=int1;i<index1;i++){
//             	if(txt.charAt(i)=='|'){
//             		index2=i;
//             		break;
//             	}
//             }
//            System.out.println(index2);
//            System.out.println(txt.substring(int1, index2-2));
//        	 }
        	 
        
//education        InputStream is = null; 
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        String txt=null;
//        try{
//           // open input stream test.txt for reading purpose.
//           is = new FileInputStream("file2.json");
//           // create new input stream reader
//           isr = new InputStreamReader(is);
//           
//           // create new buffered reader
//           br = new BufferedReader(isr);
//        
//           int value=0;
//           
//           // reads to the end of the stream 
//           while((value = br.read()) != -1)
//           {
//              // converts int to character
//              char c = (char)value;
//              txt=txt+(c);
//           
//           }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//         }finally{
//            
//            // releases resources associated with the streams
//           if(is!=null)
//              is.close();
//          if(isr!=null)
//              isr.close();
//           if(br!=null)
//               br.close();
//        }
//        int index1=txt.length();
//        System.out.println(index1);
//       int int1=txt.indexOf("education");
//        if(int1==-1){
//       	 System.out.println("bleh "); 
//        }
//       else{
//       	 System.out.println(int1);
//       	int index2=0;
//        for(int i=int1;i<index1;i++){
//        	if(txt.charAt(i)=='|'){
//        		index2=i;
//        		break;
//        	}
//        }
//       System.out.println(index2);
//       System.out.println(txt.substring(int1, index2-2));
//       	 }
//	
		
//FOR ALMA MATER        
//        
//        InputStream is = null; 
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        String txt=null;
//        try{
//           // open input stream test.txt for reading purpose.
//           is = new FileInputStream("file2.json");
//           // create new input stream reader
//           isr = new InputStreamReader(is);
//           
//           // create new buffered reader
//           br = new BufferedReader(isr);
//        
//           int value=0;
//           
//           // reads to the end of the stream 
//           while((value = br.read()) != -1)
//           {
//              // converts int to character
//              char c = (char)value;
//              txt=txt+(c);
//           
//           }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//         }finally{
//            
//            // releases resources associated with the streams
//            if(is!=null)
//               is.close();
//            if(isr!=null)
//               isr.close();
//            if(br!=null)
//               br.close();
//         }
//        int index1=txt.length();
//        System.out.println(index1);
//        int int1=txt.indexOf("alma mater");
//	if(int1==-1){
//   	 System.out.println("bleh "); 
//     }
//    else{
//   	 System.out.println(int1);
//	int index2=0;
//    for(int i=int1;i<index1;i++){
//    	if(txt.charAt(i)=='|'){
//    		index2=i;
//    		break;
//    	}
//    }
//   System.out.println(index2);
//   System.out.println(txt.substring(int1, index2-2));
//   	 }
//       
        
//FOR KNOWN FOR        InputStream is = null; 
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        String txt=null;
//        try{
//           // open input stream test.txt for reading purpose.
//           is = new FileInputStream("file2.json");
//           // create new input stream reader
//           isr = new InputStreamReader(is);
//           
//           // create new buffered reader
//           br = new BufferedReader(isr);
//        
//           int value=0;
//           
//           // reads to the end of the stream 
//           while((value = br.read()) != -1)
//           {
//              // converts int to character
//              char c = (char)value;
//              txt=txt+(c);
//           
//           }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//         }finally{
//            
//            // releases resources associated with the streams
//            if(is!=null)
//               is.close();
//            if(isr!=null)
//               isr.close();
//            if(br!=null)
//               br.close();
//         }
//        int index1=txt.length();
//        System.out.println(index1);
//        int int1=txt.indexOf("known_for");
//	if(int1==-1){
//   	 System.out.println(" "); 
//     }
//    else{
//   	 System.out.println(int1);
//	int index2=0;
//  for(int i=int1;i<index1;i++){
//  	if(txt.charAt(i)=='|'){
//  		index2=i;
//  		break;
//  	}
//  }
// System.out.println(index2);
// System.out.println(txt.substring(int1, index2-2));
//   	 }
//        

		
// FOR NAME       
//      
//        InputStream is = null; 
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        String txt=null;
//        try{
//           // open input stream test.txt for reading purpose.
//           is = new FileInputStream("file1.json");
//           // create new input stream reader
//           isr = new InputStreamReader(is);
//           
//           // create new buffered reader
//           br = new BufferedReader(isr);
//        
//           int value=0;
//           
//           // reads to the end of the stream 
//           while((value = br.read()) != -1)
//           {
//              // converts int to character
//              char c = (char)value;
//              txt=txt+(c);
//           
//           }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//         }finally{
//            
//            // releases resources associated with the streams
//            if(is!=null)
//               is.close();
//            if(isr!=null)
//               isr.close();
//            if(br!=null)
//               br.close();
//         }
//        int index1=txt.length();
//        System.out.println(index1);
//        int int1=txt.indexOf("name");
//	if(int1==-1){
//   	 System.out.println(" bleh"); 
//     }
//    else{
//   	 System.out.println(int1);
//     int index2=0;
//   for(int i=int1;i<index1;i++){
//   	if(txt.charAt(i)=='|'){
//   		index2=i;
//   		break;
//   	}
//   }
//  System.out.println(index2);
//  System.out.println(txt.substring(int1, index2-2));
//   	 }
//     
		
//FOR OCCUPATION		 
//	        
//	        InputStream is = null; 
//	        InputStreamReader isr = null;
//	        BufferedReader br = null;
//	        String txt=null;
//	        try{
//	           // open input stream test.txt for reading purpose.
//	           is = new FileInputStream("file2.json");
//	           // create new input stream reader
//	           isr = new InputStreamReader(is);
//	           
//	           // create new buffered reader
//	           br = new BufferedReader(isr);
//	        
//	           int value=0;
//	           
//	           // reads to the end of the stream 
//	           while((value = br.read()) != -1)
//	           {
//	              // converts int to character
//	              char c = (char)value;
//	              txt=txt+(c);
//	           
//	           }
//	        }
//	        catch(Exception e){
//	            e.printStackTrace();
//	         }finally{
//	            
//	            // releases resources associated with the streams
//	            if(is!=null)
//	               is.close();
//	            if(isr!=null)
//	               isr.close();
//	            if(br!=null)
//	               br.close();
//	         }
//	        int index1=txt.length();
//	        System.out.println(index1);
//	        int int1=txt.indexOf("occupation");
//	        if(int1==-1){
//	 System.out.println(" bleh"); 
// }
//else{
//	 System.out.println(int1);
//    int index2=0;
//    for(int i=int1;i<index1;i++){
//    	if(txt.charAt(i)=='|'){
//    		index2=i;
//    		break;
//    	}
//    }
//   System.out.println(index2);
//   System.out.println(txt.substring(int1, index2-2));
//	 }

		
	//This is for external links:		 JSONObject json;
//    
//    InputStream is = null; 
//    InputStreamReader isr = null;
//    BufferedReader br = null;
//    String txt=null;
//    try{
//       // open input stream test.txt for reading purpose.
//       is = new FileInputStream("file1.json");
//       // create new input stream reader
//       isr = new InputStreamReader(is);
//       
//       // create new buffered reader
//       br = new BufferedReader(isr);
//    
//       int value=0;
//       
//       // reads to the end of the stream 
//       while((value = br.read()) != -1)
//       {
//          // converts int to character
//          char c = (char)value;
//          txt=txt+(c);
//       
//       }
//    }
//    catch(Exception e){
//        e.printStackTrace();
//     }finally{
//        
//        // releases resources associated with the streams
//        if(is!=null)
//           is.close();
//        if(isr!=null)
//           isr.close();
//        if(br!=null)
//           br.close();
//     }
//    int index1=txt.indexOf("External links");
//    int index2=txt.length();
//    System.out.println(txt.substring(index1,index2-1));
//}

	//This is for summary of the person	
//  
//        
//        InputStream is = null; 
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        String txt=null;
//        try{
//           // open input stream test.txt for reading purpose.
//           is = new FileInputStream("file3.json");
//           // create new input stream reader
//           isr = new InputStreamReader(is);
//           
//           // create new buffered reader
//           br = new BufferedReader(isr);
//        
//           int value=0;
//           
//           // reads to the end of the stream 
//           while((value = br.read()) != -1)
//           {
//              // converts int to character
//              char c = (char)value;
//              txt=txt+(c);
//           
//           }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//         }finally{
//            
//            // releases resources associated with the streams
//            if(is!=null)
//               is.close();
//            if(isr!=null)
//               isr.close();
//            if(br!=null)
//               br.close();
//         }
//        int index1=txt.indexOf("extract");
//        int index2=0;
//      for(int i=index1;i<txt.length();i++){
//      	if(txt.charAt(i)=='}'){
//      		index2=i;
//      		break;
//      	}
//      }
//     System.out.println(index2);
//     System.out.println(txt.substring(index1, index2-1));
//        
//}
		
	
	public static String callURL(String myURL) {
		System.out.println("Requested URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 

		return sb.toString();
	}
	
	public static String readFile(String filename) {
	    String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}