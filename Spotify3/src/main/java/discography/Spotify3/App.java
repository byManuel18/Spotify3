package discography.Spotify3;

import enums.TypeBDD;
import model.Options;
import utilities.XMLManager;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        XMLManager.SetOption(new Options(TypeBDD.H2));
    }
}
