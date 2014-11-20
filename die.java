package pokeMon;


public class die {
private int numfaces;
die(int faces)
{
	numfaces = faces;
}
int roll()
{
	return 1 + (int)(Math.random() * numfaces);
}
}
