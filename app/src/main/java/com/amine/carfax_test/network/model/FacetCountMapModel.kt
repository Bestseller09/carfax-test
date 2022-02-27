package com.amine.carfax_test.network.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class FacetCountMapModel(
    var bedType: BedTypeModel? = null,
    var bodyStyle: BodyStyleModel? = null,
    var cabType: CabTypeModel? = null,
    var dealerIndustry: DealerIndustryModel? = null,
    var driveType: DriveTypeModel? = null,
    var engines: EnginesModel? = null,
    var exteriorColor: ExteriorColorModel? = null,
    var fuelType: FuelTypeModel? = null,
    var interiorColor: InteriorColorModel? = null,
    var make: MakeModel? = null,
    var mileageRange: MileageRangeModel? = null,
    var model: ModelModel? = null,
    var noAccidents: NoAccidentsModel? = null,
    var oneOwner: OneOwnerModel? = null,
    var options: OptionsModel? = null,
    var percentilePrices: PercentilePricesModel? = null,
    var personalUse: PersonalUseModel? = null,
    var pillarCombos: PillarCombosModel? = null,
    var popularOptions: PopularOptionsModel? = null,
    var price: PriceModel? = null,
    var recordType: RecordTypeModel? = null,
    var serviceRecords: ServiceRecordsModel? = null,
    var transmission: TransmissionModel? = null,
    var trim: TrimModel? = null,
    var yearRange: YearRangeModel? = null
) : Parcelable