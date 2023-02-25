package view.listeners;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class WarListListener implements ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting())
			return;
		JList lista=(JList)e.getSource();
		if(lista.isSelectionEmpty()){ }
		else{
			String val=(String)lista.getSelectedValue();
			
		}

	}

}
