

public class AES {

	public static void main(String[] args) {

		AES aes = new AES();
		
		String textInput = "00112233445566778899aabbccddeeff";
		
//		String textKey = "2b7e151628aed2a6abf7158809cf4f3c";
//		String textKey = "603deb1015ca71be2b73aef0857d77811f352c073b6108d72d9810a30914dff4";
		
		/* C.1 AES-128 */
//		String textKey = "000102030405060708090a0b0c0d0e0f";		
		
		/* C.2 AES-192 */
//		String textKey = "000102030405060708090a0b0c0d0e0f1011121314151617";

		/* C.3 AES-256 */
		String textKey = "000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f";
		
		System.out.printf("PLAINTEXT:\t\t%s\n", textInput);
		System.out.printf("KEY:\t\t\t%s\n\n", textKey);
		int[][] input = aes.textToBlock(textInput, 4);
		int nk = textKey.length() / 8;
		int[][] key = aes.textToBlock(textKey, nk);
		
		int[][] data = aes.cipher(key, nk, input);
		data = aes.invCipher(nk, data);
		
	}
	
	public static final int[][] sbox = {{0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76}, {0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0}, {0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15}, {0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75}, {0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84}, {0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf}, {0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8}, {0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2}, {0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73}, {0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb}, {0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79}, {0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08}, {0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a}, {0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e}, {0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf}, {0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16}};
	public static final int[][] invsbox = {{0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb}, {0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb}, {0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e}, {0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25}, {0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92}, {0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84}, {0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06}, {0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b}, {0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73}, {0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e}, {0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b}, {0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4}, {0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f}, {0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef}, {0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61}, {0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}};
	public static final int[] rcon = {0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a,
		        0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39,
		        0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a,
		        0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8,
		        0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef,
		        0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc,
		        0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b,
		        0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3,
		        0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94,
		        0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20,
		        0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35,
		        0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f,
		        0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04,
		        0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63,
		        0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd,
		        0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb};
	
	private int[][] expandedKey = null;
	
	private int[][] cipher(int[][] key, int nk, int[][] data) {
		System.out.println("CIPHER (ENCRYPT):");
		int nr = 0;
		if (nk == 4) nr = 10;
		else if (nk == 6) nr = 12;
		else if (nk == 8) nr = 14;
		
		System.out.printf("round[ 0].input\t\t%s\n", getBlockString(data));
		expandedKey = keyExpansion(key, nk, nr);
		
		data = addRoundKey(data, key);
		System.out.printf("round[ 0].k_sch\t\t%s\n", getBlockString(key));
		
		for (int i = 1; i < nr; i++) {
			System.out.printf("round[%d].start\t\t%s\n", i, getBlockString(data));
			
			data = subBytes(data);
			System.out.printf("round[%d].s_box\t\t%s\n", i, getBlockString(data));
			
			data = shiftRows(data);
			System.out.printf("round[%d].s_row\t\t%s\n", i, getBlockString(data));
			
			data = mixColumns(data);
			System.out.printf("round[%d].m_col\t\t%s\n", i, getBlockString(data));
			
			int[][] roundKey = getRoundKey(expandedKey, i);
			System.out.printf("round[%d].k_sch\t\t%s\n", i, getBlockString(roundKey));
			data = addRoundKey(data, roundKey);
		}
		System.out.printf("round[%d].start\t\t%s\n", nr, getBlockString(data));
		
		data = subBytes(data);
		System.out.printf("round[%d].s_box\t\t%s\n", nr, getBlockString(data));
		
		data = shiftRows(data);
		System.out.printf("round[%d].s_row\t\t%s\n", nr, getBlockString(data));
		
		int[][] roundKey = getRoundKey(expandedKey, nr);
		System.out.printf("round[%d].k_sch\t\t%s\n", nr, getBlockString(roundKey));
		data = addRoundKey(data, roundKey);
		
		System.out.printf("round[%d].output\t%s\n\n", nr, getBlockString(data));
		return data;
	}
	
	private int[][] invCipher(int nk, int[][] data) {
		System.out.println("INVERSE CIPHER (DECRYPT):");
		int nr = 0;
		if (nk == 4) nr = 10;
		else if (nk == 6) nr = 12;
		else if (nk == 8) nr = 14;
		
		System.out.printf("round[00].iinput\t%s\n", getBlockString(data));
		
		int[][] roundKey = getRoundKey(expandedKey, nr);
		data = addRoundKey(data, roundKey);
		System.out.printf("round[00].ik_sch\t%s\n", getBlockString(roundKey));
		
		for (int i = 1; i < nr; i++) {
			System.out.printf("round[%02d].istart\t%s\n", i, getBlockString(data));
			
			data = invShiftRows(data);
			System.out.printf("round[%02d].is_row\t%s\n", i, getBlockString(data));
			
			data = invSubBytes(data);
			System.out.printf("round[%02d].is_box\t%s\n", i, getBlockString(data));
			
			roundKey = getRoundKey(expandedKey, nr-i);
			System.out.printf("round[%02d].ik_sch\t%s\n", i, getBlockString(roundKey));
			data = addRoundKey(data, roundKey);
			System.out.printf("round[%02d].ik_add\t%s\n", i, getBlockString(data));
			
			data = invMixColumns(data);
		}
		System.out.printf("round[%02d].istart\t%s\n", nr, getBlockString(data));
		
		data = invShiftRows(data);
		System.out.printf("round[%02d].is_row\t%s\n", nr, getBlockString(data));
		
		data = invSubBytes(data);
		System.out.printf("round[%02d].is_box\t%s\n", nr, getBlockString(data));
		
		roundKey = getRoundKey(expandedKey, 0);
		System.out.printf("round[%02d].ik_sch\t%s\n", nr, getBlockString(roundKey));
		data = addRoundKey(data, roundKey);
		
		System.out.printf("round[%02d].ioutput\t%s\n", nr, getBlockString(data));
		return data;

	}
	
	private int[][] keyExpansion(int[][] key, int nk, int nr) {		
		int[][] expandedKey = new int[4][nr*4 + nk];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < nk; j++) {
				expandedKey[i][j] = key[i][j];
			}
		}
		
		for (int i = nk; i < 4 * (nr +1); i++) {
			int[] newWord = new int[nk];
			if ((i % nk) == 0) {
				int[] rotWord = new int[4];
				for (int j = 0; j < 4; j++) {
					rotWord[j] = expandedKey[j][i - 1];
				}
				rotWord = rotWord(rotWord);
//				System.out.printf("temp\t%s\n", getColumnString(rotWord));
				for (int j = 0; j < 4; j++) {
					int x = (rotWord[j] & 0xf0) >> 4;
					int y = rotWord[j] & 0x0f;
					rotWord[j] = sbox[x][y];
				}
				
				int[] prevWord = new int[4];
				for (int j = 0; j < 4; j++) {
					prevWord[j] = expandedKey[j][i - nk];
				}
				
				int[] rconWord = new int[4];
				rconWord[0] = rcon[i / nk];
				
				for (int j = 0; j < 4; j++) {
					int x =  prevWord[j] ^ rotWord[j] ^ rconWord[j];
//					System.out.println(Integer.toHexString(x));
					newWord[j] = x;
				}
			}
			else if ((nk == 8) && ((i % nk) == 4)) {
				int[] subWord = new int[4];
				for (int j = 0; j < 4; j++) {
					subWord[j] = expandedKey[j][i - 1];
				}
				for (int j = 0; j < 4; j++) {
					int x = (subWord[j] & 0xf0) >> 4;
					int y = subWord[j] & 0x0f;
					subWord[j] = sbox[x][y];
				}
				
				int[] prevWord = new int[4];
				for (int j = 0; j < 4; j++) {
					prevWord[j] = expandedKey[j][i - nk];
				}
				
				for (int j = 0; j < 4; j++) {
					int x =  prevWord[j] ^ subWord[j];
					newWord[j] = x;
				}
			}
			else {
				for (int j = 0; j < 4; j++) {
					newWord[j] = expandedKey[j][i - nk] ^ expandedKey[j][i - 1];
				}
			}
			
//			String out = "";
			for (int j = 0; j < 4; j++) {
//				System.out.println(Integer.toHexString(newWord[j]));
//				out += String.format("%02x", newWord[j]);
				expandedKey[j][i] = newWord[j];
			}
//			System.out.println(out);
		}
		
		return expandedKey;
		
	}
	
	private int[][] getRoundKey(int[][] key, int round) {
		int beg = round * 4;
		int[][] roundKey = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				roundKey[i][j] = key[i][j+beg];
			}
		}
		
		return roundKey;
	}
	
	private int[] rotWord(int[] word) {
		int[] rotWord = new int[4];
		for (int i = 1; i < 5; i++) {
			int x = i % 4;
			rotWord[i-1] = word[x];
		}
		
		return rotWord;
	}
	
	private int[][] subBytes(int[][] state) {
		int[][] newState = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = (state[i][j] & 0xf0) >> 4;
				int y = state[i][j] & 0x0f;
				newState[i][j] = sbox[x][y];
			}
		}
		
		return newState;
	}
	
	private int[][] shiftRows(int[][] state) {
		int[][] newState = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = (j + i) % 4;
				newState[i][j] = state[i][x];
			}
		}
		
		return newState;
	}
	
	private int[][] mixColumns(int[][] state) {
		int[][] newState = new int[4][4];
		
		for (int y= 0; y < 4; y++) {
			newState[0][y] = ffMultiply(0x02, state[0][y]) ^ ffMultiply(0x03, state[1][y]) ^ state[2][y] ^ state[3][y];
			newState[1][y] = state[0][y] ^ ffMultiply(0x02, state[1][y]) ^ ffMultiply(0x03, state[2][y]) ^ state[3][y];
			newState[2][y] = state[0][y] ^ state[1][y] ^ ffMultiply(0x02, state[2][y]) ^ ffMultiply(0x03, state[3][y]);
			newState[3][y] = ffMultiply(0x03, state[0][y]) ^ state[1][y] ^ state[2][y] ^ ffMultiply(0x02, state[3][y]);
		}

		return newState;
	}
	
	private int[][] addRoundKey(int[][] state, int[][]key) {
		int[][] newState = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				newState[i][j] = state[i][j] ^ key[i][j];
			}
		}
		
		return newState;
	}
	
	private int[][] invShiftRows(int[][]state) {
		int[][] newState = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = (j + i) % 4;
				newState[i][x] = state[i][j];
			}
		}
		
		return newState;
	}
	
	private int[][] invSubBytes(int[][] state) {
		int[][] newState = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = (state[i][j] & 0xf0) >> 4;
				int y = state[i][j] & 0x0f;
				newState[i][j] = invsbox[x][y];
			}
		}
		
		return newState;
	}
	
	private int[][] invMixColumns(int[][] state) {
		int[][] newState = new int[4][4];
		
		for (int y= 0; y < 4; y++) {
			newState[0][y] = ffMultiply(0x0e, state[0][y]) ^ ffMultiply(0x0b, state[1][y]) ^ ffMultiply(0x0d, state[2][y]) ^ ffMultiply(0x09, state[3][y]);
			newState[1][y] = ffMultiply(0x09, state[0][y]) ^ ffMultiply(0x0e, state[1][y]) ^ ffMultiply(0x0b, state[2][y]) ^ ffMultiply(0x0d, state[3][y]);
			newState[2][y] = ffMultiply(0x0d, state[0][y]) ^ ffMultiply(0x09, state[1][y]) ^ ffMultiply(0x0e, state[2][y]) ^ ffMultiply(0x0b, state[3][y]);
			newState[3][y] = ffMultiply(0x0b, state[0][y]) ^ ffMultiply(0x0d, state[1][y]) ^ ffMultiply(0x09, state[2][y]) ^ ffMultiply(0x0e, state[3][y]);
		}

		return newState;
	}
	
	private int ffMultiply(int a, int b) {
		int[] bytes = new int[8];

		int cur = a;
		for (int i = 0; i < 8; i++) {
			if ((b & 0x01) != 0) {
				bytes[i] = cur;
				//System.out.println(Integer.toHexString(cur));
			}
			
			b >>= 1;
			cur = xtime(cur);
		}

		int result = bytes[0];
		for (int i=1; i < bytes.length; i++) {
			result ^= bytes[i];
		}

		return result;
	}

	private int xtime (int a) {
		a <<= 1;
		if ((a & 0x100) != 0) {
			a ^= 0x1b;
		}
		return a & 0x00ff;
	}
	
	private int[][] textToBlock(String text, int n) {
		int[][] data = new int[4][n];
		
		for (int x = 0; x < text.length(); x += 2) {
			int i = (x / 2) % 4;
			int j = (x / 2) / 4;
			String hex = text.substring(x, x+2);
			data[i][j] = Integer.parseInt(hex, 16);
		}
		
//		printBlock(data);
		return data;
	}

	private void printBlock( int[][] data) {
		for (int i = 0; i < data.length; i++) {
			String out = "";
			for (int j = 0; j < data[0].length; j++) {
				out += Integer.toHexString(data[i][j]) + '\t';
			}
			System.out.println(out);
		}
	}
	
	private String getBlockString(int[][] data) {
		String out = "";
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				out += String.format("%02x", data[i][j]);
			}
		}
		
		return out;
	}
	
	private String getColumnString(int[] data) {
		String out = "";
		for (int i = 0; i < data.length; i++) {
			out += String.format("%02x", data[i]);
		}
		
		return out;
	}
}
