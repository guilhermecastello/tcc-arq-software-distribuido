package br.com.castello.scitartigos.artigos;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArtigoMapper {

    ArtigoMapper INSTANCE = Mappers.getMapper(ArtigoMapper.class);

    @Mapping(target = "suspendeCNH", source = "suspendeCNH", qualifiedByName = "booleanToLong")
    Artigo map(ArtigoDTO source);

    @Mapping(target = "suspendeCNH", source = "suspendeCNH", qualifiedByName = "longToBoolean")
    ArtigoDTO map(Artigo source);

    @org.mapstruct.Named("longToBoolean")
    default Boolean mapLongToBoolean(Long longValue) {
        return longValue != 0;
    }

    @org.mapstruct.Named("booleanToLong")
    default Long mapBooleanToLong(Boolean booleanValue) {
        return (booleanValue ? 1L : 0L);
    }
}
