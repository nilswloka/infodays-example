package examples.outsidein;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyResolverTest {

    @Test
    public void returns_lower_case_origin() {
        CompanyResolver companyResolver = new CompanyResolver();
        Confirmation confirmation = mock(Confirmation.class);
        String origin = "S2";
        when(confirmation.getOrigin()).thenReturn(origin);
        assertEquals(origin.toLowerCase(), companyResolver.companyFor(confirmation));
    }


}
