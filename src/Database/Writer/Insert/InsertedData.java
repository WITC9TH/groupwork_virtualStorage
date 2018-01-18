/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Writer.Insert;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author longi
 */
public class InsertedData {
    private List<String> varcharValues = null;
    private List<Integer> intValues = null;
    private List<Timestamp> timestampValues = null;

    public InsertedData (final List<String> varcharValues, final List<Integer> intValues, final List<Timestamp> timestampValues){
        this.varcharValues = varcharValues;
        this.intValues = intValues;
        this.timestampValues = timestampValues;
    }
    
    public List<String> getVarcharValues() {
        return varcharValues;
    }

    public List<Integer> getIntValues() {
        return intValues;
    }

    public List<Timestamp> getTimestampValues() {
        return timestampValues;
    }
}
