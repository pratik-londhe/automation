package com.brandlive.qa.automation.poc;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.common.adapters.LoginLogoutRequester;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class Try {
	
//	  public static void main(String[] args) {    
//		  	DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//			LocalDate date = LocalDate.now();
//			String dateString = FOMATTER.format(date);
//			System.out.println(dateString);
//			FOMATTER = DateTimeFormatter.ofPattern("hh:mm a");
//			LocalTime time = LocalTime.now();
//			String timeString = FOMATTER.format(time);
//			System.out.println(timeString);
//			
//			FOMATTER = DateTimeFormatter.ofPattern("MM");
//			date = LocalDate.now();
//			String monthString = FOMATTER.format(date);
//			System.out.println(monthString);
//			
//			FOMATTER = DateTimeFormatter.ofPattern("dd");
//			date = LocalDate.now();
//			String dayString = FOMATTER.format(date);
//			System.out.println(dayString);
//			
//			FOMATTER = DateTimeFormatter.ofPattern("yyyy");
//			date = LocalDate.now();
//			String yearString = FOMATTER.format(date);
//			System.out.println(yearString);
//			
//			FOMATTER = DateTimeFormatter.ofPattern("hh");
//			time = LocalTime.now().plusMinutes(30);
//			String hhString = FOMATTER.format(time);
//			System.out.println(hhString);
//			
//			FOMATTER = DateTimeFormatter.ofPattern("mm");
//			time = LocalTime.now().plusMinutes(30);
//			String mmString = FOMATTER.format(time);
//			System.out.println(mmString);
//			
//			FOMATTER = DateTimeFormatter.ofPattern("a");
//			time = LocalTime.now().plusMinutes(30);
//			String aString = FOMATTER.format(time);
//			System.out.println(aString);
//		  }  
	
//	  // driver code
//    public static void main(String args[])
//    {
//        // define the range
//        int max = 3;
//        int min = 1;
//        int range = max - min + 1;
//  
//        // generate random numbers within 1 to 3
//        for (int i = 0; i < 5; i++) {
//            int rand = (int)(Math.random() * range) + 1;
//  
//            // Output is different everytime this code is executed
//            System.out.println(rand);
//        }
//    }
	
//    static String plainText = "1e2c3a18-75e5-4af2-93dd-3210cfa5115e/ee0017b2-1a6c-11ec-ba25-6183ae12dc5b";
//    
//    public static void main(String[] args) throws Exception
//    {
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(256);
//
//        // Generate Key
//        SecretKey key = keyGenerator.generateKey();
//
//        // Generating IV.
//        byte[] IV = new byte[16];
//        SecureRandom random = new SecureRandom();
//        random.nextBytes(IV);
//        
//        System.out.println("Original Text  : "+plainText);
//        
//        byte[] cipherText = encrypt(plainText.getBytes(),key, IV);
//        System.out.println("Encrypted Text : "+Base64.getEncoder().encodeToString(cipherText));
//        
//        String decryptedText = decrypt(cipherText,key, IV);
//        System.out.println("DeCrypted Text : "+decryptedText);
//        
//    }
//    
//    public static byte[] encrypt (byte[] plaintext,SecretKey key,byte[] IV ) throws Exception
//    {
//        //Get Cipher Instance
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        
//        //Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
//        
//        //Create IvParameterSpec
//        IvParameterSpec ivSpec = new IvParameterSpec(IV);
//        
//        //Initialize Cipher for ENCRYPT_MODE
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
//        
//        //Perform Encryption
//        byte[] cipherText = cipher.doFinal(plaintext);
//        
//        return cipherText;
//    }
//    
//    public static String decrypt (byte[] cipherText, SecretKey key,byte[] IV) throws Exception
//    {
//        //Get Cipher Instance
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        
//        //Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
//        
//        //Create IvParameterSpec
//        IvParameterSpec ivSpec = new IvParameterSpec(IV);
//        
//        //Initialize Cipher for DECRYPT_MODE
//        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
//        
//        //Perform Decryption
//        byte[] decryptedText = cipher.doFinal(cipherText);
//        
//        return new String(decryptedText);
//    }
//
	
//    public static void main(String[] args) {
//        try {
//
//	         String secret = "Wp4RYjW0bg/pzkoz6sx/yhmw3FFeKcUMk74za2oVpeI";
//	         String timestamp = String.valueOf(System.currentTimeMillis()+60000); 
//	         System.out.println(timestamp);
//	         
//	         String message = "/v3/admin/auth/sign-in";
//	         String finalStr = message.concat(timestamp);
//	
//	         Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
//	         SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
//	         sha256_HMAC.init(secret_key);
//	
//	         String mac = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(finalStr.getBytes()));
//	         System.out.println(mac);
//        }
//        catch (Exception e){
//         System.out.println("Error");
//        }
//       }
	
//		public static void main(String[] args) {
//		      
//			LoginLogoutRestAdapter loginRestAdapter = new LoginLogoutRestAdapter();
//			
//			String host = "events-api.brandlive-qa.com";
//			String data = "{ \"email\": \"pradnyan.bhilare@brandlive.com\", \"password\": \"Pbhilare123!\", \"two_factor_stored\": \"\"}";
//			String e3_login_res = loginRestAdapter.getE3LoginToken(host, data);
//			System.out.println("Event3 Token: " + e3_login_res);
//			
//			System.out.println("\n----------------------------------\n");
//			
//			host = "greenroom-api.brandlive-qa.com";
//			data = "{ \"email\": \"pradnyan.bhilare@brandlive.com\", \"password\": \"Pbhilare123!\", \"storedTwoFactorEvents\": \"\", \"app\":\"greenroom\"}";
//			String gr_login_res = loginRestAdapter.getGRLoginToken(host, data);
//			System.out.println("Greenroom Token: " + gr_login_res);
//		}
	
//	public static void main(String[] args) {
//	      
//		LoginLogoutRequester loginlogoutRes = new LoginLogoutRequester();
//		
//		String host = "events-api.brandlive-qa.com";
//		String data = "{ \"email\": \"pradnyan.bhilare@brandlive.com\", \"password\": \"Pbhilare123!\", \"two_factor_stored\": \"\"}";
//		System.out.println(loginlogoutRes.getE3LoginResponse(host, data));
//		
//		System.out.println("\n----------------------------------\n");
//		
//		host = "greenroom-api.brandlive-qa.com";
//		data = "{ \"email\": \"pradnyan.bhilare@brandlive.com\", \"password\": \"Pbhilare123!\", \"storedTwoFactorEvents\": \"\", \"app\":\"greenroom\"}";
//		System.out.println(loginlogoutRes.getGRLoginResponse(host, data));
//
//	}
		
	
//	   public static void main(String args[]) {
//		      Connection c = null;
//		      try {
//		         Class.forName("org.postgresql.Driver");
//		        // String host = "postgresql-qa-serverless-cluster.cluster-cqrxncnqudqa.us-west-2.rds.amazonaws.com";
//		         String host = "load-9-1-cluster.cluster-cqrxncnqudqa.us-west-2.rds.amazonaws.com";
//		         String user = "bldashdev";
//		         //String password = "teZRexoGAvJraZ4L0Nx1";
//		         String password = "Fdafio-af&3hkdu3#&jfk9";
//		         c = DriverManager
//		            .getConnection("jdbc:postgresql://"+host+":5432/bl",
//		            user, password);
//		         Statement stmt = c.createStatement();
//		         String SQL = "select bl_profile, email from bl_profiles where email like 'pradnyan.bhilare@brandlive.com'";
//		         ResultSet rs = stmt.executeQuery(SQL);
//		         while(rs.next()){
//		             //Display values
//		             System.out.print("bl_profile: " + rs.getInt("bl_profile"));
//		          }
//		      } catch (Exception e) {
//		         e.printStackTrace();
//		         System.err.println(e.getClass().getName()+": "+e.getMessage());
//		         System.exit(0);
//		      }
//		      System.out.println("\nOpened database successfully");
//		   }

	public static void main(String[] args) {
		
		Connection connection = null;
		
		String hostName = "postgresql-qa-serverless-cluster.cluster-cqrxncnqudqa.us-west-2.rds.amazonaws.com";
		String port = "5432";
		String dataBaseUserName = "bldashdev";
		String dataBasePassword = "teZRexoGAvJraZ4L0Nx1";
		String databaseName = "bl";
		
		String filter = "derick.thomas@bb.com";
		
		String query = "select bl_profile from bl_profiles where email like '%"+filter+"%';";
		
		String url = "jdbc:postgresql://" + hostName + ":" + port + "/" + databaseName;

		System.out.println("HostName : " + hostName);
		System.out.println("Port : " + port);
		System.out.println("DatabaseName : " + databaseName);
		System.out.println("Url : " + url);
		System.out.println("Db UserName : " + dataBaseUserName);
		System.out.println("DB Password : " + dataBasePassword);

		try {
			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(url, dataBaseUserName, dataBasePassword);
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("\nbl profile number: " + resultSet.getInt("bl_profile"));
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} catch (ClassNotFoundException ex) {
			System.out.println("Caught ClassNotFoundException, while trying to connect to DB : " + ex.getMessage());
			throw new RuntimeException(ex);
		} catch (Exception ex) {
			System.out.println("Caught Exception, while trying to connect to DB : " + ex.getMessage());
			throw new RuntimeException(ex);
		}
	}
}
