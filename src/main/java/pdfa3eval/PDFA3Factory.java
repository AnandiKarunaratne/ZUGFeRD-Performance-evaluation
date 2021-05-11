package pdfa3eval;

public class PDFA3Factory {
	
	enum Type {
		  MUSTANG,
		  FOP
	}

	public static PDFA3Session getPDFSession(Type type) {
		if (type == Type.MUSTANG) { // for Mustang
			return new MustangPDFA3Session();
		}
		else { // for FOP
			return null;
		}
	}

}
