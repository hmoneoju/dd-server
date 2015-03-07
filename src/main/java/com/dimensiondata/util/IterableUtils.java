package com.dimensiondata.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableUtils {

    public static final <T> List<T> toList(Iterable<T> iterable) {
        List<T> list = new ArrayList<T>();
        if ( iterable != null ) {
            Iterator<T> iterator =  iterable.iterator();
            while (iterator.hasNext() )
                list.add( iterator.next() );
        }
        return list;
    }

}
