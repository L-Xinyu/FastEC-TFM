package es.upm.miw.fastec.latte.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "icon_scan.png";
    }

    @Override
    public Icon[] characters() {

        return EcIcons.values();
    }
}
