package com.trendsmixed.fma.utility;

public class PageView {

	public interface TotalPages {

	}

	public interface TotalElements {

	}

	public interface Sort {

	}

	public interface Size {

	}

	public interface NumberOfElements {

	}

	public interface Number {

	}

	public interface Content {

	}
	
	public interface All extends Content,Number,NumberOfElements,Size,Sort,TotalElements,TotalPages {

	}
	

}
