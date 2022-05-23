package ut.ru.homecredit.jiraplugin;

import org.junit.Test;
import ru.homecredit.jiraplugin.api.MyPluginComponent;
import ru.homecredit.jiraplugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}