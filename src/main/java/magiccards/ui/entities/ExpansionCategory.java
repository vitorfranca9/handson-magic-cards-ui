package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExpansionCategory {
	
	private int expansionCategoryId;
    private String name;
    private Character type;
	
}
