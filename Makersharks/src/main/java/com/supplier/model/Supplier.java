package com.supplier.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

	@Entity
	public class Supplier {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long supplierId;

	    @NotBlank(message = "Company name is required")
	    @Size(max = 100, message = "Company name cannot exceed 100 characters")
	    private String companyName;

	    @NotBlank(message = "Website is required")
	    @Size(max = 100, message = "Website cannot exceed 100 characters")
	    @Pattern(regexp = "^(https?:\\/\\/)?([\\da-z.-]+)\\.([a-z.]{2,6})([\\/\\w .-]*)*\\/?$", message = "Invalid website URL")
	    private String website;

	    @NotBlank(message = "Location is required")
	    @Size(max = 50, message = "Location cannot exceed 50 characters")
	    private String location;

	    @Enumerated(EnumType.STRING)
	    @NotNull(message = "Nature of business is required")
	    private NatureOfBusiness natureOfBusiness;

	    @ElementCollection(targetClass = ManufacturingProcess.class)
	    @Enumerated(EnumType.STRING)
	    @NotEmpty(message = "At least one manufacturing process is required")
	    private List<ManufacturingProcess> manufacturingProcesses;

	    // Getters and Setters

	    public enum NatureOfBusiness {
	        SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE
	    }

	    public enum ManufacturingProcess {
	        MOULDING, PRINTING_3D, CASTING, COATING
	    }
}
