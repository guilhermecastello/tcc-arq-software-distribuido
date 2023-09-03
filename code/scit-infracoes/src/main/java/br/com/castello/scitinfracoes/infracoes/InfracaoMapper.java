package br.com.castello.scitinfracoes.infracoes;

import br.com.castello.scitinfracoes.infracoes.creation.InfracaoCreation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InfracaoMapper {

    InfracaoMapper INSTANCE = Mappers.getMapper(InfracaoMapper.class);
/*
    private String address;

    private Long artigoId;

    private String artigoDesc;

    private Long pontuacao;

    private String placa;
 */
//    @Mapping(target = "address", source = "address")
//    @Mapping(target = "placa", source = "placa")
    Infracao map(InfracaoCreation source);

}
