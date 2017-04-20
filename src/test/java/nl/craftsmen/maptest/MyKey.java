package nl.craftsmen.maptest;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author Michel Schudel
 */
public class MyKey {


    private String sleuteltje;

    public String getSleuteltje() {
        return sleuteltje;
    }

    public void setSleuteltje(String sleuteltje) {
        this.sleuteltje = sleuteltje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof MyKey)) return false;

        MyKey myKey = (MyKey) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(sleuteltje, myKey.sleuteltje)
                .isEquals();
    }

//    @Override
//    public int hashCode() {
//        return 0xCAFEBABE;
//    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sleuteltje)
                .toHashCode();
    }
}
