package br.com.castello.scitinfracoes.infracoes.creation;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InfracaoCreationMapper {

    InfracaoCreationMapper INSTANCE = Mappers.getMapper(InfracaoCreationMapper.class);

//    @Mapping(target = "infracaoCreationId", source = "infracaoCreationId")
//    @Mapping(target = "statusId", source = "statusId")
//    @Mapping(target = "address", source = "address")
//    @Mapping(target = "artigo", source = "artigo")
//    @Mapping(target = "placa", source = "placa")
    InfracaoCreation map(InfracaoCreationDTO source);

//    @InheritConfiguration
    InfracaoCreationDTO map(InfracaoCreation infracaoCreation);

}
