// Source code: https://getbootstrap.com/docs/5.0/forms/layout/
import React, { useState,useEffect } from 'react';
import axios from 'axios';
import chiseiIcon from '../../assets/ChiseiIcon.png';
import kenIcon from '../../assets/KenIcon.png';
import seishinIcon from '../../assets/SeishinIcon.png';
import hPIcon from '../../assets/HPIcon.png';
import pWIcon from '../../assets/PWIcon.png';
import attackIcon from '../../assets/AttackIcon.png';
import defenseIcon from '../../assets/DefenseIcon.png';
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

function Dojo() {
    let loggedInUser = localStorage.getItem("loggedInUser");
    loggedInUser = Number.parseInt(loggedInUser, 10);
    console.log(loggedInUser);
    const baseURL = "http://localhost:8080/findUserById?userId="+loggedInUser;
    const [dojoUser, setDojoUser] = useState({
        userId: 0, userName: '', email: '', password: '',
        statId: 0,
            chisei: 0, ken: 0, seishin: 0, attack: 0, defense: 0, hit: 0, pwr: 0,
        avatarId: 0,
            armsId: '', armsName: '', armsDesc: '', armsImage: '',
            headId: '', headName: '', headDesc: '', headImage: '',
            legsId: '', legsName: '', legsDesc: '', legsImage: '',
            torsoId: '', torsoName: '', headDesc: '', torsoImage: '',
            waistId: '', waistName: '', waistDesc: '', waistImage: '',
        movesetId: 0,
            cMoveId: '', cMoveName: '', cMoveDesc: '', cMoveStat: 0, cMoveBuff: 0, cMoveKey: null,
            kMoveId: '', kMoveName: '', kMoveDesc: '', kMoveStat: 0, kMoveBuff: 0, kMoveKey: null,
            sMoveId: '', sMoveName: '', sMoveDesc: '', sMoveStat: 0, sMoveBuff: 0, sMoveKey: null,
            pMoveId: '', pMoveName: '', pMoveDesc: '', pMoveStat: 0, pMoveBuff: 0, pMoveKey: null,
        attackerId: 0, battleNo: null,
        defenderId: 0, battleNo: null
    });
    useEffect(() => {
        console.log("Retrieving user data...");
        axios.get(baseURL).then((response) => {
            setDojoUser({
                userId: Number.parseInt(response.data.userId, 10), userName: response.data.userName, email: response.data.email, password: response.data.password,
                statId: Number.parseInt(response.data.userStats.statId, 10),
                    chisei: Number.parseInt(response.data.userStats.chisei, 10),
                    ken: Number.parseInt(response.data.userStats.ken, 10),
                    seishin: Number.parseInt(response.data.userStats.seishin, 10),
                    attack: Number.parseFloat(response.data.userStats.attack, 10),
                    defense: Number.parseFloat(response.data.userStats.defense, 10),
                    hit: Number.parseFloat(response.data.userStats.hit, 10),
                    pwr: Number.parseFloat(response.data.userStats.pwr, 10),
                avatarId: Number.parseInt(response.data.avatar.avatarId, 10),
                    armsId: response.data.avatar.armsPart.armsId, armsName: response.data.avatar.armsPart.armsName, armsDesc: response.data.avatar.armsPart.armsDesc, armsImage: response.data.avatar.armsPart.armsImageFile,
                    headId: response.data.avatar.headPart.headId, headName: response.data.avatar.headPart.headName, headDesc: response.data.avatar.headPart.headDesc, headImage: response.data.avatar.headPart.headImageFile,
                    legsId: response.data.avatar.legsPart.legsId, legsName: response.data.avatar.legsPart.legsName, legsDesc: response.data.avatar.legsPart.legsDesc, legsImage: response.data.avatar.legsPart.legsImageFile,
                    torsoId: response.data.avatar.torsoPart.torsoId, torsoName: response.data.avatar.torsoPart.torsoName, torsoDesc: response.data.avatar.torsoPart.torsoDesc, torsoImage: response.data.avatar.torsoPart.torsoImageFile,
                    waistId: response.data.avatar.waistPart.waistId, waistName: response.data.avatar.waistPart.waistName, waistDesc: response.data.avatar.waistPart.waistDesc, waistImage: response.data.avatar.waistPart.waistImageFile,
                movesetId: Number.parseInt(response.data.moveset.movesetId, 10),
                    cMoveId: response.data.moveset.chiMove.cMoveId, cMoveName: response.data.moveset.chiMove.moveName,cMoveDesc: response.data.moveset.chiMove.moveDesc,cMoveStat: Number.parseInt(response.data.moveset.chiMove.moveStat, 10),cMoveBuff: Number.parseFloat(response.data.moveset.chiMove.moveBuff, 10),cMoveKey: null,
                    kMoveId: response.data.moveset.kenMove.kMoveId, kMoveName: response.data.moveset.kenMove.moveName,kMoveDesc: response.data.moveset.kenMove.moveDesc,kMoveStat: Number.parseInt(response.data.moveset.kenMove.moveStat, 10),kMoveBuff: Number.parseFloat(response.data.moveset.kenMove.moveBuff, 10),kMoveKey: null,
                    sMoveId: response.data.moveset.seiMove.sMoveId, sMoveName: response.data.moveset.seiMove.moveName,sMoveDesc: response.data.moveset.seiMove.moveDesc,sMoveStat: Number.parseInt(response.data.moveset.seiMove.moveStat, 10),sMoveBuff: Number.parseFloat(response.data.moveset.seiMove.moveBuff, 10),sMoveKey: null,
                    pMoveId: response.data.moveset.surpriseMove.pMoveId, pMoveName: response.data.moveset.surpriseMove.moveName,pMoveDesc: response.data.moveset.surpriseMove.moveDesc,pMoveStat: Number.parseInt(response.data.moveset.surpriseMove.moveStat, 10),pMoveBuff: Number.parseFloat(response.data.moveset.surpriseMove.moveBuff, 10),pMoveKey: null,
                attackerId: Number.parseInt(response.data.attacker.attackerId, 10), battleNo: null,
                defenderId: Number.parseInt(response.data.defender.defenderId, 10), battleNo: null
            })
        })
    }, [setDojoUser])
    return (
        <div className="playableScreen">
            <p className='headers'>Welcome, {dojoUser.userName}!</p>
            <p className='headers'>You are registered as User #{dojoUser.userId}.</p>
            <p className='headers'>This is your Dojo.</p>
            <table className='user-stats'>
                <thead>
                    <tr>
                        <th className='stat'>Hit Points</th>
                        <th className='stat'>Power Level</th>
                        <th className='stat'>Attack</th>
                        <th className='stat'>Defense</th>
                        <th className='stat'>Chisei</th>
                        <th className='stat'>Ken</th>
                        <th className='stat'>Seishin</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td className='stat'><img src={hPIcon} className='icon'  /></td>
                        <td className='stat'><img src={pWIcon} className='icon' /></td>
                        <td className='stat'><img src={attackIcon} className='icon' /></td>
                        <td className='stat'><img src={defenseIcon} className='icon' /></td>
                        <td className='stat'><img src={chiseiIcon} className='icon' /></td>
                        <td className='stat'><img src={kenIcon} className='icon' /></td>
                        <td className='stat'><img src={seishinIcon} className='icon' /></td>
                    </tr>
                    <tr>
                        <td className='stat'><span className='center'>{dojoUser.hit}</span></td>
                        <td className='stat'><span className='center'>{dojoUser.pwr}</span></td>
                        <td className='stat'><span className='center'>{dojoUser.attack}</span></td>
                        <td className='stat'><span className='center'>{dojoUser.defense}</span></td>
                        <td className='stat'><span className='center'>{dojoUser.chisei}</span></td>
                        <td className='stat'><span className='center'>{dojoUser.ken}</span></td>
                        <td className='stat'><span className='center'>{dojoUser.seishin}</span></td>
                    </tr>
                </tbody>
            </table>
            <form className="moveset-select">
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th>Moveset</th>
                            </tr>
                        </thead>
                    <tbody>
                        <tr>
                            <td>Chisei Move</td>
                            <td>{dojoUser.cMoveName}</td>
                            <td>{dojoUser.cMoveDesc}</td>
                        </tr>
                        <tr>
                            <td>Ken Move</td>
                            <td>{dojoUser.kMoveName}</td
                            ><td>{dojoUser.kMoveDesc}</td>
                        </tr>
                        <tr>
                            <td>Seishin Move</td>
                            <td>{dojoUser.sMoveName}</td>
                            <td>{dojoUser.sMoveDesc}</td>
                        </tr>
                        <tr>
                            <td>Surprise Move</td>
                            <td>{dojoUser.pMoveName}</td>
                            <td>{dojoUser.pMoveDesc}</td>
                        </tr>
                    </tbody>
                    </table>
                </div>
            </form>
            <div className='avatar-window'>
                <form name="avatar-choose" id="avatar-choose">
                    <img src={mArtistHead} className='body-part battle-body-head' />
                    <img src={mArtistTorso} className='body-part battle-body-torso' />
                    <img src={mArtistArms} className='body-part battle-body-arms' />
                    <img src={mArtistWaist} className='body-part battle-body-waist' />
                    <img src={mArtistLegs} className='body-part battle-body-legs' />
                    <table className='avatar-drops'>
                        <tr>
                            <td>User</td>
                            <td>{dojoUser.avatarId}</td>
                        </tr>
                        <tr>
                            <td>Head</td>
                            <td><select>
                                    <option value={dojoUser.headId} selected>{dojoUser.headName}</option>
                                </select>
                            </td>
                            <td>{dojoUser.headDesc}</td>
                        </tr>
                        <tr>
                            <td>Torso</td>
                            <td><select>
                                    <option value={dojoUser.torsoId} selected>{dojoUser.torsoName}</option>
                                </select>
                            </td>
                            <td>{dojoUser.torsoDesc}</td>
                        </tr>
                        <tr>
                            <td>Arms</td>
                            <td><select>
                                    <option value={dojoUser.armsId} selected>{dojoUser.armsName}</option>
                                </select>
                            </td>
                            <td>{dojoUser.armsDesc}</td>
                        </tr>
                        <tr>
                            <td>Waist</td>
                            <td><select>
                                    <option value={dojoUser.waistId} selected>{dojoUser.waistName}</option>
                                </select>
                            </td>
                            <td>{dojoUser.waistDesc}</td>
                        </tr>
                        <tr>
                            <td>Legs</td>
                            <td><select>
                                    <option value={dojoUser.legsId} selected>{dojoUser.legsName}</option>
                                </select>
                            </td>
                            <td>{dojoUser.legsDesc}</td>
                        </tr>
                        <div className="button">
                            <button type="button" className="btn btn-primary">Set Avatar</button>
                        </div>
                    </table>
                </form>
            </div>
        </div>
    );
}
export default Dojo;