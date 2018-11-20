/**
 * @(#)CCelula.java
 *
 *
 * @author Rodrigo Richard Gomes
 * @version 1.00 2018/3/16
 */
 
public class CCelula {
    public CMorador item;
    public CCelula prox;        
    public CCelula(CMorador valorItem, CCelula proxCelula)
    {
        item = valorItem;
        prox = proxCelula;
    }               
    public CCelula(CMorador valorItem)
    {
        item = valorItem;
        prox = null;
    }                           
    public CCelula()
    {
        item = null;
        prox = null;
    }                           
}