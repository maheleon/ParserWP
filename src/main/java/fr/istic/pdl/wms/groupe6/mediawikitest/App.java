package fr.istic.pdl.wms.groupe6.mediawikitest;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	ConfigFileWikipedia search = new ConfigFileWikipedia("en", "Colombia");
    	ParserWikipedia parser = new ParserWikipedia();
    	System.out.println(parser.getEntityFromWikiData(search.getTitle()));
    }
}
