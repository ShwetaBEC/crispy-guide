package com.ymedialabs.ci.cd.sample.utils;

import java.util.Collection;
import java.util.Map;

public class NullCheckUtility {
	
	private NullCheckUtility() {}

	/** This method returns true if the collection is null or is empty.
	 * @param collection
	 * @return true | false
	 */
	public static boolean isEmpty( Collection<?> collection ){
		return ( collection == null || collection.isEmpty() );
	}

	/**
	 * This method returns true of the map is null or is empty.
	 * @param map
	 * @return true | false
	 */
	public static boolean isEmpty( Map<?, ?> map ){
		return ( map == null || map.isEmpty() );
	}

	/**
	 * This method returns true if the input array is null or its length is zero.
	 * @param array
	 * @return true | false
	 */
	public static boolean isEmpty( Object[] array ){
		return ( array == null || array.length == 0 );
	}

	/**
	 * This method returns true if the input string is null or its length is zero.
	 * @param string
	 * @return true | false
	 */
	public static boolean isEmpty( String string ){
		return ( string == null || string.trim().isEmpty());
	}
}
