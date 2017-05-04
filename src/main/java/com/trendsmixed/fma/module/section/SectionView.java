package com.trendsmixed.fma.module.section;

import com.trendsmixed.fma.utility.PageView;

public class SectionView {

	public static interface Id {
	}

	public static interface Code {
	}

	public static interface Name {
	}

	public static interface MTBFTarget {
	}

	public static interface MTTRTarget {
	}

	public static interface MDTTarget {
	}

	public static interface SectionType {
	}

	public static interface All extends Id, Code, Name, MTBFTarget, MTTRTarget, MDTTarget, PageView.All {
	}

}
