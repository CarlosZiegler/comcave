package visitor;

public class TextKarton extends KartonComponent
{
	private String text;
	public TextKarton(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public void accept(IVisitor v) {
		v.visitTextKarton(this);
		
	}

	
	
	
	
}
