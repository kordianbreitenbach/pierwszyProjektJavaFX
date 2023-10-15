package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.text.Text;



public class SampleController {
	 @FXML
	    private Text myText; // ta zmienna musi miec taka samo nazwe 
@FXML
	    private Text imieninyText;

	    @FXML
	    private Text widoczne;
	    
	    public void initialize() {
	        // pobierz dzisiejsza date
	        LocalDate today = LocalDate.now();
	        
	        // twoz obiekt formatowania daty
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        
	        //konwertuj date na lancuch i przypisz jo do elementu text
	        String formattedDate = today.format(dateFormatter);
	        myText.setText(formattedDate);
	        
	        
	           // definiuje liste imion i dat
        List<Imieniny> imionaIDaty = new ArrayList<>();
        imionaIDaty.add(new Imieniny("Jan", "15-10-2023"));
        imionaIDaty.add(new Imieniny("barabasz", "15-10-2023"));
        imionaIDaty.add(new Imieniny("szymon", "15-10-2023"));
        imionaIDaty.add(new Imieniny("Anna", "16-10-2023"));
        imionaIDaty.add(new Imieniny("Tomasz", "18-10-2023"));
        imionaIDaty.add(new Imieniny("Barbara", "19-10-2023"));
        imionaIDaty.add(new Imieniny("Marek", "20-10-2023"));
	    
        int iloscDni = imionaIDaty.size(); 
        boolean imieninyWBliskichDniach = false;
        for (int i = 0; i < iloscDni; i++) {
     
            for (Imieniny imieniny : imionaIDaty) {
                if (formattedDate.equals(imieniny.getData())) {
                    imieninyWBliskichDniach = true;
                    
                   
                    String istniejacyTekst = imieninyText.getText();
                    String nowyTekst = istniejacyTekst + imieniny.getImie()+ ", " ;
                    imieninyText.setText(nowyTekst);
                    
                }
            }
            String imionaImienin = imieninyText.getText();
            if (!imionaImienin.isEmpty()) {
                imionaImienin = imionaImienin.substring(0, imionaImienin.length() - 2);
                imieninyText.setText(imionaImienin);
            }
            String istniejacyTekst = imieninyText.getText();
            if (!istniejacyTekst.isEmpty()) {
            	
            	int ostatniPrzecinekIndex = istniejacyTekst.lastIndexOf(",");
            	 if (ostatniPrzecinekIndex != -1) {
            		 istniejacyTekst = istniejacyTekst.substring(0, ostatniPrzecinekIndex) + " i" + istniejacyTekst.substring(ostatniPrzecinekIndex + 1);
            		 
            		 imieninyText.setText(istniejacyTekst);
            	 }
            	
            }

            if (imieninyWBliskichDniach) {
                break;
            }
        }
        if (imieninyWBliskichDniach) {
            widoczne.setVisible(true);
        }else {
        	 widoczne.setVisible(false);
        }
        
	    }
	    
	    private static class Imieniny {
	        private String imie;
	        private String data;

	        public Imieniny(String imie, String data) {
	            this.imie = imie;
	            this.data = data;
	        }

	        public String getImie() {
	            return imie;
	        }

	        public String getData() {
	            return data;
	        }
	    }
	    
}


