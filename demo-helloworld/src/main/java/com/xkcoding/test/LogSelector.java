package com.xkcoding.test;

import com.xkcoding.helloworld.Log;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

/**
 * <p>
 * <a href="LogSelector.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/1/4 15:46
 */
public class LogSelector extends AdviceModeImportSelector<Log> {
    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        return new String[]{Log.class.getName()};
    }
}
