package master;

import java.sql.Date;
import java.util.Objects;

public class Premium extends Bezeroa{
    
    private Date iraungitzeData;

    public Premium(String izena, String abizena, Date jdata, String pasahitza, Hizkuntza hizkuntza,
            String erabiltzailea) {
        super(izena, abizena, jdata, pasahitza, hizkuntza, erabiltzailea);
    }

    public Date getIraungitzeData() {
        return iraungitzeData;
    }

    public void setIraungitzeData(Date iraungitzeData) {
        this.iraungitzeData = iraungitzeData;
    }

    @Override
    public String toString() {
        return "Premium [iraungitzeData=" + iraungitzeData + ", izena=" + izena + ", abizena=" + abizena + ", Jdata="
                + Jdata + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", hizkuntza=" + hizkuntza
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Premium other = (Premium) obj;
        return Objects.equals(iraungitzeData, other.iraungitzeData);
    }
    
    
}