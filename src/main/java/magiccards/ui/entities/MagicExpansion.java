package magiccards.ui.entities;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MagicExpansion {

	private int expansionId;
    private String name;
    private String ptBRName;
    private String linkName;
    private String code;
    private Date LaunchDate;
    private ExpansionCategory ExpansionCategory;
    private Boolean isPromo;
    private Boolean isLegal;
}
