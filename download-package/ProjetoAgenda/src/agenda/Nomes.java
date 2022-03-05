package agenda;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Nomes extends PlainDocument {

	@Override
	public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) 
			throws BadLocationException {
			super.insertString(offset, str.replaceAll("[^a-z|â|ã|ê|ô|õ|~|ç|á|à|é^ |^A-Z|Â|Ã|Ê|Ô|Õ|~|Ç|Á|À|É^ ]",""), attr);
		}
		public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
			super.insertString(offset, str.replaceAll("[^a-z|â|ã|ê|ô|õ|~|ç|á|à|é^ |^A-Z|Â|Ã|Ê|Ô|Õ|~|Ç|Á|À|É^ ]",""), attr);
		}
	}
