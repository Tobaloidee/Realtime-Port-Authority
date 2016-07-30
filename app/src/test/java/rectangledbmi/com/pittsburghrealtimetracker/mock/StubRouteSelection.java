package rectangledbmi.com.pittsburghrealtimetracker.mock;

import java.util.Collections;

import rectangledbmi.com.pittsburghrealtimetracker.selection.RouteSelection;
import rectangledbmi.com.pittsburghrealtimetracker.world.Route;

/**
 * <p>Stub route selection for unit testing.</p>
 * <p>Created by epicstar on 7/18/16.</p>
 * @since 76
 * @author Jeremy Jao
 */
public class StubRouteSelection {
    /**
     * Gets a stub route selection... The route number is from {@link PatApiMock#testRoute1}
     *
     * @return a stub route selection
     */
    public static RouteSelection getRouteSelection() {
        return RouteSelection.create(new Route(PatApiMock.testRoute1, "", 1, 1, true),
                Collections.singleton(PatApiMock.testRoute1));
    }
}