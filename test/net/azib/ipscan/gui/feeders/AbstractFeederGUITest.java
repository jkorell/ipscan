/**
 * 
 */
package net.azib.ipscan.gui.feeders;

import net.azib.ipscan.config.Labels;
import net.azib.ipscan.feeders.Feeder;
import net.azib.ipscan.feeders.RangeFeeder;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * AbstractFeederGUITest
 *
 * @author Anton Keks
 */
public class AbstractFeederGUITest {
	
	private AbstractFeederGUI feederGUI;
	
	@Before
	public void setUp() throws Exception {
		feederGUI = new AbstractFeederGUI(new Shell()) {
			public void initialize(int rowHeight) {
			}
			public String getFeederName() {
				return "Mega Feeder";
			}
			public Feeder createFeeder() {
				feeder = new RangeFeeder("127.0.0.1", "127.0.0.2");
				return feeder;
			}
			public String[] serialize() {
				return new String[0];
			}
			public void unserialize(String[] parts) {
			}
			public String[] serializePartsLabels() {
				return new String[0];
			}
		};
	}

	@Test
	public void testGetInfo() {
		assertEquals("Mega Feeder: 127.0.0.1 - 127.0.0.2", feederGUI.getInfo());
	}
	
	@Test
	public void serializePartsAreLabels() throws Exception {
		// TODO: make test for each FeederGUI, extending this class
		for (String label : feederGUI.serializePartsLabels()) {
			Labels.getLabel(label);
		}
	}
	
}
