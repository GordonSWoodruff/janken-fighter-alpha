// Source code: https://getbootstrap.com/docs/5.0/forms/layout/
import axios from 'axios';
import { useState, useEffect } from 'react';
import {useHistory} from 'react-router-dom';
import defaultArms from '../../assets/A-20-00-00-00-10-001.png';
import defaultHead from '../../assets/H-30-00-00-00-10-001.png';
import defaultLegs from '../../assets/L-40-00-00-00-10-001.png';
import defaultTorso from '../../assets/T-50-00-00-00-10-001.png';
import defaultWaist from '../../assets/W-60-00-00-00-10-001.png';
import mArtistArms from '../../assets/A-20-20-20-10-10-001.png';
import mArtistHead from '../../assets/H-30-20-20-20-80-001.png';
import mArtistBackHead from '../../assets/H-33-20-20-20-80-001.png';
import mArtistLegs from '../../assets/L-40-20-20-00-10-001.png';
import mArtistTorso from '../../assets/T-50-20-20-00-20-001.png';
import mArtistWaist from '../../assets/W-60-20-20-20-00-001.png';
import fMonsterArms from '../../assets/A-20-40-50-70-00-001.png';
import fMonsterHead from '../../assets/H-30-40-50-70-40-001.png';
import fMonsterLegs from '../../assets/L-40-40-50-70-10-001.png';
import fMonsterTorso from '../../assets/T-50-40-50-70-00-001.png';
import fMonsterBackTorso from '../../assets/T-55-40-50-70-20-001.png';
import fMonsterWaist from '../../assets/W-60-40-50-10-00-001.png';

function SignUp2() {
    let loggedInUser = localStorage.getItem("loggedInUser");
    loggedInUser = Number.parseInt(loggedInUser, 10);
    const baseURL = "http://localhost:8080/findUserById?userId="+loggedInUser;
    const [ avatar, setAvatar ] = useState({
        userId: 999,
            avatarId: 999,
            armsId: 2,
                arms: 'A-20-00-00-00-10-001', armsName: 'Default Arms',
                armsDesc: 'A totally non-descript set of arms. Seriously, these arms are not exciting at all.',
                armsImage: '../../assets/A-20-00-00-00-10-001.png',
            backArmsId: 2,
                backArms: 'A-22-00-00-00-10-001',backArmsImage: '../../assets/A-22-00-00-00-10-001.png',
            headId: 2,
                head: 'H-30-00-00-00-10-001',headName: 'Default Head',
                headDesc: "A totally non-descript head. Seriously, it's nothing special.",
                headImage: '../../assets/H-30-00-00-00-10-001.png',
            backHeadId: 2,
                backHead: 'H-33-00-00-00-10-001',backheadImage: '../../assets/H-33-00-00-00-10-001.png',
            legsId: 2,
                legs: 'L-40-00-00-00-10-001',legsName: 'Default Legs',
                legsDesc: 'A totally non-descript pair of legs. Seriously, these legs really are pretty average.',
                legsImage: '../../assets/L-40-00-00-00-10-001.png',
            backLegsId: 2,
                backLegs: 'L-44-00-00-00-10-001',backLegsImage: '../../assets/L-44-00-00-00-10-001.png',
            torsoId: 2,
                torso: 'T-50-00-00-00-10-001',torsoName: 'Default Torso',
                torsoDesc: "A totally non-descript torso. Seriously, there really isn't anything special about this torso.",
                torsoImage: '../../assets/T-50-00-00-00-10-001.png',
            backTorsoId: 2,
                backTorso: 'T-55-00-00-00-10-001',backTorsoImage: '../../assets/T-55-00-00-00-10-001.png',
            waistId: 2,
                waist: 'W-60-00-00-00-10-001',waistName: 'Default Waist',
                waistDesc: 'A totally non-descript waist. Seriously, this waist is about as regular as they can get.',
                waistImage: '../../assets/W-60-00-00-00-10-001.png',
            backWaistId: 2,
                backWaist: 'W-66-00-00-00-10-001',backWaistImage: '../../assets/W-66-00-00-00-10-001.png'
    })
    const history = useHistory();
    const changeHandler = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        const tempChoose = {...avatar};
        tempChoose[name] = value;
        setAvatar(tempChoose);
    }
    useEffect(() => {
        console.log("Retrieving user avatar...");
        axios.get(baseURL).then((response) => {
            setAvatar({
                userId: Number.parseInt(response.data.userId,10),
                    avatarId: Number.parseInt(response.data.avatar.avatarId,10),
                    armsId: Number.parseInt(response.data.avatar.armsPart.armsId,10),
                        arms: response.data.avatar.armsPart.arms, armsName: response.data.avatar.armsPart.armsName,
                        armsDesc: response.data.avatar.armsPart.armsDesc,
                        armsImage: response.data.avatar.armsPart.armsImage,
                    backArmsId: Number.parseInt(response.data.avatar.backArmsPart.backArmsId,10),
                        backArms: response.data.avatar.backArmsPart.backArms,backArmsImage: response.data.avatar.backArmsPart.backArmsImage,
                    headId: Number.parseInt(response.data.avatar.headPart.headId,10),
                        head: response.data.avatar.headPart.head,headName: response.data.avatar.headPart.headName,
                        headDesc: response.data.avatar.headPart.headDesc,
                        headImage: response.data.avatar.headPart.headImage,
                    backHeadId: Number.parseInt(response.data.avatar.backHeadPart.backHeadId,10),
                        backHead: response.data.avatar.backHeadPart.backHead,backheadImage: response.data.avatar.backHeadPart.backheadImage,
                    legsId: Number.parseInt(response.data.avatar.legsPart.legsId,10),
                        legs: response.data.avatar.legsPart.legs,legsName: response.data.avatar.legsPart.legsName,
                        legsDesc: response.data.avatar.legsPart.legsDesc,
                        legsImage: response.data.avatar.legsPart.legsImage,
                    backLegsId: Number.parseInt(response.data.avatar.backLegsPart.backLegsId,10),
                        backLegs: response.data.avatar.backLegsPart.backLegs,backLegsImage: response.data.avatar.backLegsPart.backLegsImage,
                    torsoId: Number.parseInt(response.data.avatar.torsoPart.torsoId,10),
                        torso: response.data.avatar.torsoPart.torso,torsoName: response.data.avatar.torsoPart.torsoName,
                        torsoDesc: response.data.avatar.torsoPart.torsoDesc,
                        torsoImage: response.data.avatar.torsoPart.torsoImage,
                    backTorsoId: Number.parseInt(response.data.avatar.backTorsoPart.backTorsoId,10),
                        backTorso: response.data.avatar.backTorsoPart.backTorso,backTorsoImage: response.data.avatar.backTorsoPart.backTorsoImage,
                    waistId: Number.parseInt(response.data.avatar.waistPart.waistId,10),
                        waist: response.data.avatar.waistPart.waist,waistName: response.data.avatar.waistPart.waistName,
                        waistDesc: response.data.avatar.waistPart.waistDesc,
                        waistImage: response.data.avatar.waistPart.waistImage,
                    backWaistId: Number.parseInt(response.data.avatar.backWaistPart.backWaistId,10),
                        backWaist: response.data.avatar.backWaistPart.backWaist,backWaistImage: response.data.avatar.backWaistPart.backWaistImage
            })
        })
    },[setAvatar])
    const avatarSubmitHandler = () => {
        axios.post('http://localhost:8080/chooseAvatar',avatar).then(response => {
            history.push('/sign-up3');
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        })
    }
    return (
        <div className="main-content">
            <form name="avatar-choose" id="avatar-choose">
                <div className='signup-avatar-window'>
                    <img src={defaultHead} className='body-part' />
                    <img src={defaultTorso} className='body-part' />
                    <img src={defaultArms} className='body-part' />
                    <img src={defaultWaist} className='body-part' />
                    <img src={defaultLegs} className='body-part' />
                </div>
                <table className='signup-avatar-drops'>
                    <tbody>
                        <tr>
                            <td>Id</td>
                            <td><input type="text" disabled value={avatar.avatarId} /></td>
                        </tr>
                        <tr>
                            <td>Character Type</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Head</td>
                            <td><select name="headPart" value={avatar.headId} onChange={changeHandler}>
                                    <option defaultValue={avatar.headId}>{avatar.headName}</option>
                                    <option value={mArtistHead}>Martial Artist Head</option>
                                    <option value={fMonsterHead}>Fuzzy Monster Head</option>
                                </select>
                            </td>
                            <td>{avatar.headDesc}</td>
                        </tr>
                        <tr>
                            <td>Torso</td>
                            <td><select name="torsoPart" value={avatar.torsoId}>
                                    <option defaultValue={avatar.torsoId}>{avatar.torsoName}</option>
                                    <option value={mArtistTorso}>Martial Artist Torso</option>
                                    <option value={fMonsterTorso}>Fuzzy Monster Torso</option>
                                </select>
                            </td>
                            <td>{avatar.torsoDesc}</td>
                        </tr>
                        <tr>
                            <td>Arms</td>
                            <td><select name="armsPart" value={avatar.armsId}>
                                    <option defaultValue={avatar.armsId}>{avatar.armsName}</option>
                                    <option value={mArtistArms}>Martial Artist Arms</option>
                                    <option value={fMonsterArms}>Fuzzy Monster Arms</option>
                                </select>
                            </td>
                            <td>{avatar.armsDesc}</td>
                        </tr>
                        <tr>
                            <td>Waist</td>
                            <td><select name="waistPart" value={avatar.waistId}>
                                    <option defaultValue={avatar.waistId}>{avatar.waistName}</option>
                                    <option value={mArtistWaist}>Martial Artist Waist</option>
                                    <option value={fMonsterWaist}>Fuzzy Monster Waist</option>
                                </select>
                            </td>
                            <td>{avatar.waistDesc}</td>
                        </tr>
                        <tr>
                            <td>Legs</td>
                            <td><select name="legsPart" value={avatar.legsId}>
                                    <option defaultValue={avatar.legsId}>{avatar.legsName}</option>
                                    <option value={mArtistLegs}>Martial Artist Legs</option>
                                    <option value={fMonsterLegs}>Fuzzy Monster Legs</option>
                                </select>
                            </td>
                            <td>{avatar.legsDesc}</td>
                        </tr>
                    </tbody>
                </table>
                <div className="button">
                        <button type="button" className="btn btn-primary" onClick={avatarSubmitHandler}>Set Avatar</button>
                </div>
            </form>
    </div>
    );
}
export default SignUp2;