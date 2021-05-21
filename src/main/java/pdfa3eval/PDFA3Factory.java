package pdfa3eval;

public class PDFA3Factory {
	
	public enum Type {
		  MUSTANG,
		  FOP
	}

	public static PDFA3Session getPDFSession(Type type) {
		if (type == Type.MUSTANG) { // for Mustang
			return new MustangPDFA3Session();
		}
		else if (type == Type.FOP){ // for FOP
			return new FopPDFA3Session();
		}
		else {
			System.out.println("Invalid type");
			return null;
		}
	}

}
