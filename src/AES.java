
public class AES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private byte[][] mixColumns(byte[][] state) {
		byte [][] newState = new byte[4][4];
		
		for y in number of columns (4):
			newState[0,y] = multiply({02}, state(0,y)) XOR multiply({03}, state(1,y)) XOR state(2,y) XOR state(3,y)
			newState[1,y] = state(0,y) XOR multiply({02}, state(1,y)) XOR multiply({03}, state(2,y)) XOR state(3,y)
			newState[2,y] = state(0,y) XOR state(1,y) XOR multiply({02}, state(2,y)) XOR multiply({03}, state(3,y))
			newState[3,y] = multiply({03}, state(3,y)) XOR state(1,y) XOR state(2,y) XOR multiply({02}, state(3,y))

		return newState
	}
	
	private byte ffMultiply(byte a, byte b) {
		bytes = []
		if rightmost bit in b is 1:
			append a to bytes

		byte prev = a
		for bit in b (starting at second bit from right and moving left):
			prev = xtime(prev)
			if bit is 1:
				append prev to bytes

		byte result = bytes[0]
		for i=1 to length of bytes:
			result = result XOR bytes[i]

		return result
	}

	private byte xtime (byte a) {
		a << 1
		if a & 0x100 {
			a = a ^ 0x1b
		}
		return a
	}

}
