package org.interview.screening.program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Encryption {
	
	
	
	public static final String ENCRYPTED_INPUT = "input.txt";
	public static final String DECRYPTED_OUTPUT = "output.txt";
	
	public static final String[] ENCODED_DATA = {
			"1JKJ'pz'{ol'{yhklthyr'vm'{ol'Jvu{yvs'Kh{h'Jvywvyh{pvu5",
			"1PIT'pz'h'{yhklthyr'vm'{ol'Pu{lyuh{pvuhs'I|zpulzz'Thjopul'Jvywvyh{pvu5",
			"1KLJ'pz'{ol'{yhklthyr'vm'{ol'Kpnp{hs'Lx|pwtlu{'Jvywvyh{pvu5"
	};
	public static final String[] DECODED_DATA = {
			"*CDC is the trademark of the Control Data Corporation.",
			"*IBM is a trademark of the International Business Machine Corporation.",
			"*DEC is the trademark of the Digital Equipment Corporation."
	};
	public int[] encodeDecodeArray = new int[126];
	
	public Encryption(){
		initMySelf();
	}
	
	public void initMySelf(){
		
		//initialize encodeDecodeArray
		for (int i = 0; i < encodeDecodeArray.length; i++) {
			encodeDecodeArray[i] = -1;
			
		}
		
		if (ENCODED_DATA == null || DECODED_DATA == null || ENCODED_DATA.length == 0 || DECODED_DATA.length == 0) {
			throw new RuntimeException("Encode & Decode pattern not provided");
		}
		
		if (ENCODED_DATA.length != DECODED_DATA.length) {
			throw new RuntimeException("Given encoded data length doesn't match decoded data length");
		}
		
		for (int i = 0; i < ENCODED_DATA.length; i++) {
			String encodedInput = ENCODED_DATA[i];
			String decodedInput = DECODED_DATA[i];
			char[] ecodedCharArray = encodedInput.toCharArray();
			char[] decodedCharArray = decodedInput.toCharArray();
			if (ecodedCharArray == null || decodedCharArray == null || ecodedCharArray.length != decodedCharArray.length) {
				throw new RuntimeException("Given encoded data doesn't match with its corresponding decoded data character length");
			}
			
			for (int j = 0; j < ecodedCharArray.length; j++) {
				if (encodeDecodeArray[i] == -1) {
					encodeDecodeArray[(int)ecodedCharArray[j]] = (int)decodedCharArray[j];
				}else if (encodeDecodeArray[(int)ecodedCharArray[j]] != (int)decodedCharArray[j]) {
					throw new RuntimeException("Error recognizing the pattern");
				}
			}
		}
		
	}
	
	public void decode(){
		InputStream inputStreamData = Encryption.class.getClassLoader().getResourceAsStream(ENCRYPTED_INPUT);
		String outPutFilePath = Encryption.class.getClassLoader().getResource(DECRYPTED_OUTPUT).getPath();
		File file = new File(outPutFilePath);
		BufferedWriter bw = null;
		int ch;
		try {
			bw=new BufferedWriter(new FileWriter(file));
			while((ch = inputStreamData.read()) != -1)
				bw.write(ch==10?(char)ch:(char)encodeDecodeArray[ch]);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStreamData.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Data decrypted to the following file: " + outPutFilePath);
	}
	
	public static void main(String[] args) {
		Encryption encr = new Encryption();
		encr.decode();
	}
	
}
