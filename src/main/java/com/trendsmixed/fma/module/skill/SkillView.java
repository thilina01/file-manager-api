package com.trendsmixed.fma.module.skill;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SkillView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {

    }

    public interface All extends Id, Code, Name, PageView.All {

    }

}
